import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import {CourseService} from "../../Service/CourseService";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {
  form: FormGroup;
  errorMessage: any;

  constructor(private fb: FormBuilder, private route: ActivatedRoute,
    private courseService:CourseService, private router: Router) {

      this.form = this.fb.group({
        name: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
        semester: ['', [Validators.required, Validators.pattern('([0-3]){1}')]],
        description: ['', [Validators.required]],
        image: ['', [Validators.required]],
        state: ['', [Validators.required, Validators.pattern('([0-1]){1}')]],
        creationDate: ['', [Validators.required]]
      });

     }

  ngOnInit(): void {

    this.courseService.findById(this.route.snapshot.params['courseId']).subscribe((data: {}) => {
      console.log(data);
      
        this.form.patchValue({
          name: data['name'],
          semester: data['semester'],
          description: data['description'],
          nationality: data['nationality'],
          image: data['image'],
          state: data['state'],
          creationDate: data['creationDate']
        });
      
      
    });
  }
  
  submit() {
    if (!this.form.valid) {
      return;
    }
    console.log(this.form.value);
    this.courseService.update(this.form.value).subscribe((result) => {
      this.router.navigate(['/list-course/']);
    }, (err) => {
      console.log(err);
    });
  }

  cancel(){
    this.router.navigate(['/list-course']);
  }

  get name() { return this.form.get('name'); }
  get semester() {return this.form.get('semester');}
  get description() {return this.form.get('description');}
  get image() {return this.form.get('image');}
  get state() {return this.form.get('state');}
  get creationDate() {return this.form.get('creationDate');}
}