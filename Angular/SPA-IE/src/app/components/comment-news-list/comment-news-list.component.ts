import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { CommentNewsService } from 'src/app/services/commentNews.service';
@Component({
  selector: 'app-comment-news-list',
  templateUrl: './comment-news-list.component.html',
  styleUrls: ['./comment-news-list.component.css']
})
export class CommentNewsListComponent implements OnInit {

  public gridData: any;
  public action: string;
  newsForm: FormGroup;
  constructor(public service:CommentNewsService, private route: ActivatedRoute, public router: Router) {
    route.params.subscribe(val => {
      this.action = this.route.snapshot.params['action'];
      this.getComments();
    }) }

  ngOnInit(): void {
    this.action = this.route.snapshot.params['action'];
    this.getComments();
  }
  getComments() {
    this.service.getComment().subscribe((data: {}) => {
      console.log(data);
      this.gridData = data;
    });
  }
  delete(id: any){   
    console.log(id);   
     this.service.deleteComment(id).subscribe(res => {   
           this.getComments();     }, (err) => {   
                 console.log(err);     });;   }
 }

