import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import swal from "sweetalert2";
import { Router, ActivatedRoute } from "@angular/router";
import { CommentNewsService } from 'src/app/services/commentNews.service';
import { CommentNews } from 'src/app/model/CommentNews';

@Component({
  selector: 'app-comment-news-form',
  templateUrl: './comment-news-form.component.html',
  styleUrls: ['./comment-news-form.component.css']
})
export class CommentNewsFormComponent implements OnInit {
  form: FormGroup;
  action: string;
  constructor(private formBuilder: FormBuilder, private router: Router,
    private service: CommentNewsService,
    private route: ActivatedRoute) {
    this.form = this.formBuilder.group({
      idNews: ['', [Validators.required]],
      idUserProfile: ['', [Validators.required]],
      commentary:['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],

      });
  }

  ngOnInit(): void {

    let idUpdate = this.route.snapshot.params['idUpdate'];
    let idDetails = this.route.snapshot.params['idDetail'];
    if(idDetails!=null){
      this.action = 'DETAILS';
      this.loadComments(idDetails);
      this.blockForm();
    }else if(idUpdate != null){
      this.action = 'UPDATE';
      this.loadComments(idUpdate);
    }else{
      this.action = 'ADD';
    }
  }
  submit() {
    if (this.form.invalid) return;
    let commentNews = new CommentNews();
    commentNews.idNews = this.idNews.value;
    commentNews.idUserProfile= this.idUserProfile.value;
    commentNews.commentary=this.commentary.value;;
    console.log(commentNews);
    if(this.action == 'ADD'){
      this.service.addComment(commentNews).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success comment add'
        }).finally(() => {
          this.router.navigate(['/comment-news-list'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    }else if(this.action == 'UPDATE'){
      commentNews.idComment = this.route.snapshot.params['idUpdate'];
      this.service.updateComments(commentNews).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success comments update'
        }).finally(() => {
          this.router.navigate(['/comment-news-list'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    }
  }

  blockForm() {
    this.form.disable();
  }

  unBlockForm() {
    this.form.enable();
  }
  cancel(){
    this.router.navigate(['/']);
  }
  loadComments(id: number){
    let commentNews: any = {};
    this.service.getCommentById(id).subscribe((data: {}) => {
      commentNews = data;
      this.form.controls['idNews'].setValue(commentNews.idNews);
      this.form.controls['idUserProfile'].setValue(commentNews.idUserProfile); 
      this.form.controls['commentary'].setValue(commentNews.commentary);         
    });
  }

  get idComment() { return this.form.get('idComment'); }
  get idNews() { return this.form.get('idNews'); }
  get idUserProfile() { return this.form.get('idUserProfile'); }
  get commentary() { return this.form.get('commentary'); }
  get username() { return this.form.get('username'); }

}
