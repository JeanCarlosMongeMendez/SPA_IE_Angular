import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import swal from "sweetalert2";
import { Router, ActivatedRoute } from "@angular/router";
import { NewsService } from 'src/app/services/news.service';
import { News } from 'src/app/model/News';
@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent implements OnInit {

  form: FormGroup;
  action: string;
  constructor(private formBuilder: FormBuilder, private router: Router,
    private service: NewsService,
    private route: ActivatedRoute) {
    this.form = this.formBuilder.group({
      idUserCreator: ['', [Validators.required]],
      description: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
      newsType: ['',[Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
      });
  }

  ngOnInit(): void {
    let idUpdate = this.route.snapshot.params['idUpdate'];
    let idDetails = this.route.snapshot.params['idDetail'];
    if(idDetails!=null){
      this.action = 'DETAILS';
      this.loadNews(idDetails);
      this.blockForm();
    }else if(idUpdate != null){
      this.action = 'UPDATE';
      this.loadNews(idUpdate);
    }else{
      this.action = 'ADD';
    }
  }
  submit() {
    if (this.form.invalid) return;
    let news = new News();
    news.idUserCreator = this.idUserCreator.value;
    news.description= this.description.value;
    news.documentation= "text";
    news.newsType = this.newsType.value;
    news.image = "image";
    console.log(news);
    if(this.action == 'ADD'){
      this.service.addNews(news).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success news add'
        }).finally(() => {
          this.router.navigate(['/news-list'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    }else if(this.action == 'UPDATE'){
      news.idNews = this.route.snapshot.params['idUpdate'];
      this.service.updateNews(news).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success news update'
        }).finally(() => {
          this.router.navigate(['/news-list'])
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
  loadNews(id: number){
    let news: any = {};
    this.service.getNewsById(id).subscribe((data: {}) => {
      news = data;
      this.form.controls['idUserCreator'].setValue(news.idUserCreator); 
      this.form.controls['description'].setValue(news.description);
      this.form.controls['newsType'].setValue(news.newsType);     
    });
  }

  get idNews() { return this.form.get('idNews'); }
  get username() { return this.form.get('username'); }
  get idUserCreator() { return this.form.get('idUserCreator'); }
  get description() { return this.form.get('description'); }
  get documentation() { return this.form.get('documentation'); }
  get newsType() { return this.form.get('newsType'); }
  get image() { return this.form.get('image'); }
  

}
