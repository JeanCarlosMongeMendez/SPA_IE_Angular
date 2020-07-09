import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { NewsService } from 'src/app/services/news.service';

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



      
     }

  ngOnInit(): void {
  }

}
