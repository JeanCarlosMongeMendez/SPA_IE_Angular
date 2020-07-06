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
  ];

  constructor(public router: ActivatedRoute) {
    
  }
}
