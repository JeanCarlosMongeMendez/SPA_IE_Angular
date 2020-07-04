import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { StudentService } from 'src/app/Services/student.service';
import { Router } from "@angular/router";
import swal from "sweetalert2";
import { Student } from 'src/app/model/Student';
import { GeneralService } from 'src/app/services/general.service';


@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css']
})
export class StudentAddComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  error = '';
  loading: boolean = false;
  provinces: any = [];
  cantons: any = [];
  districts: any = [];

  constructor(private formBuilder: FormBuilder, private router: Router, 
    private service: StudentService, private generalService: GeneralService) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
      password: ['', [Validators.required]],
      interests: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
      email: ['', [Validators.required, Validators.email]],
      canton: ['', [Validators.required]],
      province: ['', [Validators.required]],
      district: ['', [Validators.required]],
      identificationCard: ['', [Validators.required]],
      isAsip: [false]
    });
  }

  ngOnInit(): void {
    this.getProvinces();
  }

  submit() {
    this.error = '';
    this.submitted = true;
    if (this.form.invalid || this.loading) return;
    this.blockForm();
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
    student.isAsip = this.isAsip.value;
    student.isActive = false;
    this.service.save(student).subscribe(data => {
      swal.fire({
        icon: 'success',
        text: 'Success'
      }).finally(() => {
        this.router.navigate(['/students-list'])
      });
    }, res => {
      this.error = res.error.text;
      this.unBlockForm();
    });
      
  }

  blockForm() {
    this.loading = true;
    this.form.disable();
  }

  unBlockForm() {
    this.loading = false;
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
    this.router.navigate(['/students-list']);
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
