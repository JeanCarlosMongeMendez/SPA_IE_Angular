import { Component } from '@angular/core';
import { Item } from './model/Item';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SPA-IE';

  items: Item[] = [
    {
      text:'List of students',
      path:'/student-list/APPROVED'
    },

    {
      text:'Disapproved students',
      path:'/student-list/DISAPPROVED'
    },
    {
      text:'List of professors',
      path:'/professor-list'
    },
    {
      text:'List of news',
      path:'/news-list'
    },
    {
      text:'List of comment',
      path:'/comment-news-list'
    },
  ];

  constructor(public router: ActivatedRoute) {
    
  }
}
