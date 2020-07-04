import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from "@angular/forms";
import { ProfessorService } from '../../Services/professor.service';
import { RestService } from '../../Services/rest.service';
import { Professor } from 'src/app/model/professor';

import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs";
import swal from "sweetalert2";
import { UserProfile } from 'src/app/model/UserProfile';
import { Canton } from 'src/app/model/Canton';
import { Province } from 'src/app/model/Province';
import { District } from 'src/app/model/District';

@Component({
  selector: 'app-add-professor',
  templateUrl: './add-professor.component.html',
  styleUrls: ['./add-professor.component.css']
})
export class AddProfessorComponent implements OnInit {
  form: FormGroup;
  submitted = false;
  error = '';
  loading: boolean = false;
  provinces: any;
  cantons: any;
  districts: any;
  constructor(private formBuilder: FormBuilder,
    private router: Router, private restService: RestService, private professorService: ProfessorService) { 
      this.form = this.formBuilder.group({

        username: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
        password: ['', [Validators.required]],
        interests: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
        email: ['', [Validators.required, Validators.email]],
        admin: [false],
       // canton: ['', [Validators.required]],
       canton: [1, [Validators.required]],
        province: [1, [Validators.required]],
        district: [1, [Validators.required]],
        degree: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
  
      });
  


    }

  ngOnInit(): void {
    this.getProvinces();
    this.getCantons(this.provinces[3]);
    this.getDistricts(this.cantons[1]);

  }

  submit() {
    let canton = new Canton();
    canton.idCanton=1
    let province = new Province();
    province.idProvince=1;
    let district = new District();
    district.idDistrict=1;
    canton.idCanton=1
    this.error = '';
    this.submitted = true;
    if (this.form.invalid || this.loading) return;
    this.blockForm();
    let professor = new Professor();
    let userProfile = new UserProfile();
    userProfile.username = this.username.value;
    userProfile.password = this.password.value;
    userProfile.userPhoto = "image";
    userProfile.interests = this.interests.value;
    userProfile.email = this.email.value;
    userProfile.admin = this.admin.value;
    userProfile.canton = canton;
    userProfile.province =province;
    userProfile.district = district;
    userProfile.creationDate = new Date();
    userProfile.enable = true;
    professor.userProfile = userProfile;
    professor.degree = this.degree.value;
  
    this.professorService.save(professor).subscribe(data => {
      swal.fire({
        icon: 'success',
        text: 'Success'
      }).finally(() => {
        this.router.navigate(['/professor-list'])
      });
    }, res => {
      this.error = res.error.text;
      this.unBlockForm();
    })
  }
  addProfessor() {
  
    this.professorService.save(this.form.value).subscribe((result) => {
      this.router.navigate(['/professor-list'])
    }, (err) => {
      console.log(err);
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
  cancel(){
    this.router.navigate(['/professor-list']);
  }
  getProvinces() {
    this.provinces = [];
    this.restService.getProvinces().subscribe((data: {}) => {
      console.log(data);
      this.provinces = data;
    })
  }

  getCantons(id: number) {
    this.cantons = [];
    this.restService.getCantos(id).subscribe((data: {}) => {
      console.log(data);
      this.cantons = data;
    })
  }

  getDistricts(id: number) {
    this.districts = [];
    this.restService.getDistricts(id).subscribe((data: {}) => {
      console.log(data);
      this.districts = data;
    })
  }

  get username() { return this.form.get('username'); }
  get password() { return this.form.get('password'); }
  get interests() { return this.form.get('interests'); }
  get email() { return this.form.get('email'); }
  get admin() { return this.form.get('admin'); }
  get canton() { return this.form.get('canton'); }
  get province() { return this.form.get('province'); }
  get district() { return this.form.get('district'); }
  get degree() { return this.form.get('degree'); }

}
