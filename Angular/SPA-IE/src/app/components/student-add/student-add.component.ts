import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { StudentService } from "../../services/student.service";
import { Student } from "../../model/Student";
import { Canton } from '../../model/Canton'
import { District } from '../../model/District'
import { Province } from '../../model/Province'
import { Router } from "@angular/router";
import { UserProfile } from 'src/app/model/UserProfile';


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

  constructor(private formBuilder: FormBuilder, private router: Router, private service: StudentService) {
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
    let userProfile = new UserProfile();
    userProfile.username = this.username.value;
    userProfile.password = this.password.value;
    userProfile.userPhoto = "image";
    userProfile.interests = this.interests.value;
    userProfile.email = this.email.value;
    userProfile.admin = false;
    userProfile.canton = (new Canton().idCanton = this.canton.value);
    userProfile.province = (new Province().idProvince = this.province.value);
    userProfile.district = (new District().idDistrict = this.district.value);
    userProfile.creationDate = new Date();
    userProfile.enable = true;
    student.userProfile = userProfile;
    student.identificationCard = this.identificationCard.value;
    student.isAsip = this.isAsip.value;
    student.isActive = false;
    this.service.save(student);
      
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
    this.service.getProvinces().subscribe((data:{ }) => {
      console.log(data);
      this.provinces = data;
    })
  }

  cancel(){
    this.router.navigate(['/students-list']);
  }

  getCantons(id: number){
    this.cantons = [];
    this.service.getCantos(id).subscribe((data:{ }) => {
      console.log(data);
      this.cantons = data;
    })
  }

  getDistricts(id: number){
    this.districts = [];
    this.service.getDistricts(id).subscribe((data:{ }) => {
      console.log(data);
      this.districts = data;
    })
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
