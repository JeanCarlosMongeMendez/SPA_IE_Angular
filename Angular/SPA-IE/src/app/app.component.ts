import { Component } from '@angular/core';
import { Item } from './model/Item';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GeneralService } from './services/general.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SPA-IE';

  form: FormGroup;
  public opened = false;
  public User: string;
  public userType: string;
  public ACTIVE_USER: any;
  items: Item[] = [];


  constructor(public router: ActivatedRoute,public route: Router, private formBuilder: FormBuilder, private generalService: GeneralService) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  this.items = [
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

  singIn(type: string) {
    this.userType = type;
    this.form.controls['username'].setValue(''); 
    this.form.controls['password'].setValue('');
    this.opened = true;
  }

  submit(){
    if (this.form.invalid) return;
    this.generalService.singIn(this.form.value, this.userType).subscribe(res => {
      console.log(res);
      if(this.userType == 'student'){this.User = res['username'];}
      else{
        let userProfile: any;
        userProfile = res['userProfile'];
        console.log(userProfile);
        this.User = userProfile.username;
        this.ACTIVE_USER = res;
        if(userProfile.admin == true){
          this.items = [
            {
              text: 'List of students',
              path: '/student-list/APPROVED'
            },
        
            {
              text: 'Disapproved students',
              path: '/student-list/DISAPPROVED'
            },
        
            {
              text: 'List of professors',
              path: '/professor-list'
            },
        
            {
              text: 'List Courses',
              path: '/list-course'
            },
          ];
        }
      }
      close();
    }, (err) => {
      this.User = '';
      this.form.controls['username'].setValue(''); 
      this.form.controls['password'].setValue('');
    })
  }

  close(){
    this.opened = false; 
  }

  get username() { return this.form.get('username'); }
  get password() { return this.form.get('password'); }
}
