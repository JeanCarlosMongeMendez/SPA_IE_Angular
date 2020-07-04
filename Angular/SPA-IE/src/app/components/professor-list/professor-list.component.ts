import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import { ProfessorService } from '../../Services/professor.service';

import { ActivatedRoute, Router } from '@angular/router';
import {Observable} from "rxjs";
import swal from "sweetalert2";

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.css']
})
export class ProfessorListComponent implements OnInit {

  public gridData: any;
  professors:any = [];

  constructor(public rest:ProfessorService, private route: ActivatedRoute, private router: Router ){ }

  ngOnInit(): void {
    this.getProfessors();
  }

  getProfessors() {
    this.professors = [];
    this.rest.listAll().subscribe((data: {}) => {
      console.log(data);
      this.professors = data;
      this.gridData = data;
    });
  }
  

  add() {
    this.router.navigate(['/professor-add']);
  }


  }




