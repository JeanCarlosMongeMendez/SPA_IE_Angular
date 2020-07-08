import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/Services/student.service';
import { Student } from 'src/app/model/Student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})

export class StudentListComponent implements OnInit {

  public gridData: any;
  public action: string;
  public opened = false;
  public studentDelete: Student;

  constructor(public service: StudentService, private route: ActivatedRoute, public router: Router) {
    route.params.subscribe(val => {
      this.action = this.route.snapshot.params['action'];
      if (this.action == 'APPROVED') { this.getStudentsApproved() };
      if (this.action == 'DISAPPROVED') { this.getStudentsDisapproved() };
    })
  }

  ngOnInit(): void {
  }

  getStudentsApproved() {
    this.service.listApproved().subscribe((data: {}) => {
      console.log(data);
      this.gridData = data;
    });
  }

  getStudentsDisapproved() {
    this.service.listDisapproved().subscribe((data: {}) => {
      console.log(data);
      this.gridData = data;
    });
  }

  approve(id: number) {
    console.log(id);
    this.service.approve(id).subscribe(res => {
      this.getStudentsApproved();
    }, (err) => {
      console.log(err);
    });
  }

  reject(id: number) {
    this.service.reject(id).subscribe(res => {
      this.getStudentsDisapproved();
    }, (err) => {
      console.log(err);
    });;
  }

  delete(id: any) {
    this.service.findById(id).subscribe(res => {
      this.studentDelete = res;
      this.opened = true;
    }, (err) => {
      console.log(err);
    })
  }

  close(status) {
    if (status == 'yes') {
      this.service.delete(this.studentDelete.idUserProfile).subscribe(res => {
        this.getStudentsApproved();
      }, (err) => {
        console.log(err);
      });;
    }
    this.opened = false;
  }
}
