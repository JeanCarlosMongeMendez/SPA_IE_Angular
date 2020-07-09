import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { StudentService } from 'src/app/Services/student.service';
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { Student } from 'src/app/model/Student';
import { GeneralService } from 'src/app/services/general.service';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {

  form: FormGroup;
  provinces: any = [];
  cantons: any = [];
  districts: any = [];
  action: string;

  constructor(private formBuilder: FormBuilder, private router: Router, 
    private service: StudentService,
    private route: ActivatedRoute, 
    private generalService: GeneralService) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
      interests: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      canton: ['', [Validators.required]],
      province: ['', [Validators.required]],
      district: ['', [Validators.required]],
      identificationCard: ['', [Validators.required]],
      isAsip: ['']
    });
  }

  ngOnInit(): void {
    let idUpdate = this.route.snapshot.params['idUpdate'];
    let idDetails = this.route.snapshot.params['idDetail'];
    if(idDetails!=null){
      this.action = 'DETAILS';
      this.loadStudent(idDetails);
      this.blockForm();
    }else if(idUpdate != null){
      this.action = 'UPDATE';
      this.loadStudent(idUpdate);
    }else if(this.action = 'ADD'){
      this.action = 'ADD';
    }else {
      this.action = 'LOGIN'
    }
    console.log(this.action);
    this.getProvinces();
  }

  submit() {
    if (this.form.invalid) return;
    let student = new Student();
    student.username = this.username.value;
    student.password = this.password.value;
    student.userPhoto = "image";
    student.interests = this.interests.value;
    student.email = this.email.value;
    student.admin = false;
    student.idCanton = this.canton.value;
    student.idProvince = this.province.value;
    student.idDistrict = this.district.value;
    student.creationDate = new Date();
    student.isEnable = true;
    student.identificationCard = this.identificationCard.value;
    student.asip = this.isAsip.value;
    if(this.action == 'ADD'){
      this.service.save(student).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success student add'
        }).finally(() => {
          this.router.navigate(['/student-list/DISAPPROVED'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    }else if(this.action == 'UPDATE'){
      student.idUserProfile = this.route.snapshot.params['idUpdate'];
      this.service.update(student).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success student update'
        }).finally(() => {
          this.router.navigate(['/student-list'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    }else {
      this.service.save(student).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success student registred'
        }).finally(() => {
          this.router.navigate(['/'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    }
  }

  blockForm() {
    this.form.disable();
  }

  unBlockForm() {
    this.form.enable();
  }

  getProvinces(){
    this.provinces = [];
    this.generalService.getProvinces().subscribe((data:{ }) => {
      console.log(data);
      this.provinces = data;
    })
  }

  cancel(){
    this.router.navigate(['/']);
  }

  getCantons(id: number){
    this.cantons = [];
    this.generalService.getCantos(id).subscribe((data:{ }) => {
      console.log(data);
      this.cantons = data;
    })
  }

  getDistricts(id: number){
    this.districts = [];
    this.generalService.getDistricts(id).subscribe((data:{ }) => {
      console.log(data);
      this.districts = data;
    })
  }

  provinceSelectOnChange(id){
    this.getCantons(id);
  }

  cantonSelectOnChange(id){
    this.getDistricts(id);
  }

  loadStudent(id: number){
    let student: any = {};
    this.service.findById(id).subscribe((data: {}) => {
      student = data;
      console.log(data);
      this.form.controls['username'].setValue(student.username); 
      this.form.controls['password'].setValue(student.password);
      this.form.controls['email'].setValue(student.email);
      this.form.controls['isAsip'].setValue(student.asip);
      this.form.controls['interests'].setValue(student.interests);
      this.form.controls['province'].setValue(student.idProvince);
      this.getCantons(student.idProvince);
      this.form.controls['canton'].setValue(student.idCanton);
      this.getDistricts(student.idCanton);
      this.form.controls['district'].setValue(student.idDistrict);
      this.form.controls['identificationCard'].setValue(student.identificationCard);
    });
  }

  get username() { return this.form.get('username'); }
  get password() { return this.form.get('password'); }
  get email() { return this.form.get('email'); }
  get isAsip() { return this.form.get('isAsip'); }
  get interests() { return this.form.get('interests'); }
  get canton() { return this.form.get('canton'); }
  get province() { return this.form.get('province'); }
  get district() { return this.form.get('district'); }
  get identificationCard() { return this.form.get('identificationCard'); }
}
