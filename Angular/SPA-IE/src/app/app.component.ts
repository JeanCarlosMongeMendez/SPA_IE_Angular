import { Component } from '@angular/core';
import { Item } from './model/Item';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Student } from './model/Student';
import { GeneralService } from './services/general.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SPA-IE';

  form: FormGroup;
  public User: string;

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
      text:'Login',
      path:'/student-add'
    },

    {
      text:'Sign in',
      path:'/'
    {
      text:'List of professors',
      path:'/professor-list'
    },
  ];

  constructor(public router: ActivatedRoute, private formBuilder: FormBuilder, private generalService: GeneralService) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  singIn(){
    if (this.form.invalid) return;
    let student = new Student();
    student.username = this.username.value;
    student.password = this.password.value;
    this.generalService.singIn(student).subscribe(res => {
      this.User = res.toString();
    }, (err) => {
      console.log(err);
    })
  }

  get username() { return this.form.get('username'); }
  get password() { return this.form.get('password'); }
}
