import { Component, OnInit } from '@angular/core';
import { NewsService } from 'src/app/services/news.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import swal from "sweetalert2";

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {
  public gridData: any;
  public action: string;
  newsForm: FormGroup;
 

  constructor(public service:NewsService, private route: ActivatedRoute, public router: Router) {
    route.params.subscribe(val => {
      this.action = this.route.snapshot.params['action'];
      this.getNews();
    })
   }

  ngOnInit(): void {
    this.action = this.route.snapshot.params['action'];
    this.getNews();
  }
  getNews() {
    this.service.getNews().subscribe((data: {}) => {
      console.log(data);
      this.gridData = data;
    });
  }

  delete(id: any){   
    console.log(id);   
     this.service.deleteNews(id).subscribe(res => {   
           this.getNews();     }, (err) => {   
                 console.log(err);     });;   }
 }


