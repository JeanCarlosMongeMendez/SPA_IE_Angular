import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from "@angular/forms";


import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs";
import swal from "sweetalert2";
import { ProfessorService } from 'src/app/Services/professor.service';
import { Professor } from 'src/app/model/professor';
import { UserProfile } from 'src/app/model/UserProfile';


@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.css']
})
export class ProfessorListComponent implements OnInit {

  public gridData: any;
  public action: string;
  public popoverTitle: string = 'Warning';
  public popoverMessage: string = 'Do you want to really delete?';
  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;
  public opened = false;
  public proffesorDelete: Professor;

  constructor(public rest: ProfessorService, private route: ActivatedRoute, public router: Router) {
    route.params.subscribe(val => {
      this.action = this.route.snapshot.params['action'];
      this.getProfessors();
    })

  }

  ngOnInit(): void {
    this.action = this.route.snapshot.params['action'];
    this.getProfessors();
  }

  getProfessors() {
    this.rest.listAll().subscribe((data: {}) => {
      console.log(data);
      this.gridData = data;
    });
  }

  close(status) {
    if (status == 'yes') {
      this.rest.delete(this.proffesorDelete.userProfile.idUserProfile).subscribe(res => {
        this.getProfessors();
      }, (err) => {
        console.log(err);
      });;
    }
    this.opened = false;
  }


  delete(id: any) {
    this.rest.findById(id).subscribe(res => {
      this.proffesorDelete = res;
      this.opened = true;
    }, (err) => {
      console.log(err);
    })
  } 
}