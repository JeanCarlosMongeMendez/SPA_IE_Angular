import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { StudentService } from 'src/app/Services/student.service';
import { Router } from "@angular/router";
import swal from "sweetalert2";
import { Student } from 'src/app/model/Student';
import { GeneralService } from 'src/app/services/general.service';

@Component({
  selector: 'app-student-update',
  templateUrl: './student-update.component.html',
  styleUrls: ['./student-update.component.css']
})
export class StudentUpdateComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  error = '';
  loading: boolean = false;
  provinces: any = [];
  cantons: any = [];
  districts: any = [];

  constructor() { }

  ngOnInit(): void {
  }

}
