import { Component, OnInit } from '@angular/core';

import {CourseService} from "../../Service/CourseService";
import { ActivatedRoute, Router } from '@angular/router';

import swal from 'sweetalert2';

@Component({
  selector: 'app-list-course',
  templateUrl: './list-course.component.html',
  styleUrls: ['./list-course.component.css']
})
export class ListCourseComponent implements OnInit {

  public gridData: any;
  courses:any =[];

  constructor(public courseService:CourseService, private route: ActivatedRoute, public router:Router) { }

  ngOnInit(): void {
    this.getCourses(); 
  }

  getCourses(){
    this.courses=[];
    this.courseService.list().subscribe((data:{}) =>{
      console.log(data);
      this.gridData = data;
      this.courses=data;
    });
  }

  add() {
    this.router.navigate(['/form-course']);
  }

  delete(id) {
 
    swal.fire({
      title: "Are you sure?",
      text: "Once deleted, you will not be able to recover this course file!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.value) {
        this.courseService.delete(id)
        .subscribe(res => {
            this.getCourses();
          }, (err) => {
            console.log(err);
          }
        );
        swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
      }
    })


  }

}
