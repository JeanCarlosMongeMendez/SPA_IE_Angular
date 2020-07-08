import { Component } from '@angular/core';
import { Item } from './model/Item';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import swal from "sweetalert2";
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
  items: Item[] = [
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

  constructor(public router: ActivatedRoute,public route: Router, private formBuilder: FormBuilder, private generalService: GeneralService) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  singIn(type: string) {
    this.userType = type;
    this.opened = true;
  }

  submit(){
    if (this.form.invalid) return;
    this.generalService.singIn(this.form.value, this.userType).subscribe(res => {
      this.User = res['username'];
      close();
    }, (err) => {
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
