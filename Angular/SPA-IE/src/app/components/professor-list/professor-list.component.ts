import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from "@angular/forms";


import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs";
import swal from "sweetalert2";
import { ProfessorService } from 'src/app/Services/professor.service';


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


  delete(id: any){   
       console.log(id);   
        this.rest.delete(id).subscribe(res => {   
              this.getProfessors();     }, (err) => {   
                    console.log(err);     });;   }
    }
  
