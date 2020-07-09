import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/Services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})

export class StudentListComponent implements OnInit {

  public gridData: any;
  public action: string;

  constructor(public service:StudentService, private route: ActivatedRoute, public router: Router) {
    route.params.subscribe(val => {
      this.action = this.route.snapshot.params['action'];
      this.getStudents();
    })
  }

  ngOnInit(): void {
    this.action = this.route.snapshot.params['action'];
    this.getStudents();
  }
  getStudents() {
    this.service.list().subscribe((data: {}) => {
      console.log(data);
      this.gridData = data;
    });
  }

  approve(id: number) {
    this.service.approve(id).subscribe(res => {
      this.router.navigate(['/student-list/APPROVED']);
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
