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
}
