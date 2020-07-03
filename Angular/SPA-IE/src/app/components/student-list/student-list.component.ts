import { Component, OnInit } from '@angular/core';
import { StudentService } from '../../Services/student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})

export class StudentListComponent implements OnInit {

  public gridData: any;
  public students: any = []

  constructor(public service:StudentService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }
  getStudents() {
    this.students = [];
    this.service.list().subscribe((data: {}) => {
      console.log(data);
      this.students = data;
      this.gridData = data;
    });
  }

  add() {
    this.router.navigate(['/student-add']);
  }
}
