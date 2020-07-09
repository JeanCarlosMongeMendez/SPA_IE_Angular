import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../Service/CourseService";
import {Course} from "../../model/course";
import { ActivatedRoute, Router} from "@angular/router";
//import {Observable} from "rxjs";
//import {AuthenticationService} from "../../../../services/authentication.service";
import swal from "sweetalert2";

@Component({
  selector: 'app-form-course',
  templateUrl: './form-course.component.html',
  styleUrls: ['./form-course.component.css']
})
export class FormCourseComponent implements OnInit {
  form: FormGroup;
  submitted = false;
  error = '';
  loading: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private courseService: CourseService,
              private route: ActivatedRoute) {

    this.form = this.formBuilder.group({
      name: ['', [Validators.required]],
      semester: ['', [Validators.required, Validators.pattern('([0-3]){1}')]],
      description: ['', [Validators.required]],
      image: ['', [Validators.required]],
      //state: ['', [Validators.required, Validators.pattern('([0-1]){1}')]],
      creationDate: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {

  }

  submit(){
    this.error='';
    this.submitted = true;
    if(this.form.invalid||this.loading) return;
    this.blockForm();
    let course = new Course();
    course.name = this.name.value;
    course.semester = this.semester.value;
    course.description = this.description.value;
    course.image = this.image.value;
  //  course.state = this.state.value;
    course.creationDate = this.creationDate.value;

    this.courseService.createCourse(course).subscribe(data => {
      swal.fire({
        icon: 'success',
        text: 'El registro fue éxitoso'
      }).finally(() => {
        this.router.navigate(['/list-course']);
      });
    }, res => {
      this.error = res.error.text;
      this.unBlockForm();
    })
  }

  blockForm() {
    this.loading = true;
    this.form.disable();
  }

  unBlockForm() {
    this.loading = false;
    this.form.enable();
  }

  cancel(){

    this.router.navigate(['/courses/']);

    //this.router.navigate(['/students']);
  }

  get name() { return this.form.get('name'); }
  get semester() {return this.form.get('semester');}
  get description() {return this.form.get('description');}
  get image() {return this.form.get('image');}
  //get state() {return this.form.get('state');}
  get creationDate() {return this.form.get('creationDate');}


}
