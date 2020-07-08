import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import swal from "sweetalert2";
import { ProfessorService } from 'src/app/Services/professor.service';
import { GeneralService } from 'src/app/services/general.service';
import { Professor } from 'src/app/model/professor';
import { UserProfile } from 'src/app/model/UserProfile';
import { Canton } from 'src/app/model/Canton';
import { Province } from 'src/app/model/Province';
import { District } from 'src/app/model/District';
@Component({
  selector: 'app-professor-form',
  templateUrl: './professor-form.component.html',
  styleUrls: ['./professor-form.component.css']
})
export class ProfessorFormComponent implements OnInit {
  form: FormGroup;
  provinces: any = [];
  cantons: any = [];
  districts: any = [];
  action: string;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private service: ProfessorService,
    private route: ActivatedRoute,
    private generalService: GeneralService) {
    this.form = this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
      password: ['', [Validators.required]],
      interests: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
      email: ['', [Validators.required, Validators.email]],
      canton: ['', [Validators.required]],
      province: ['', [Validators.required]],
      district: ['', [Validators.required]],
      degree: ['', [Validators.required, Validators.pattern('^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$')]],
    });



  }

  ngOnInit(): void {

    let idUpdate = this.route.snapshot.params['idUpdate'];
    let idDetails = this.route.snapshot.params['idDetail'];
    if (idDetails != null) {
      this.action = 'DETAILS';
      this.loadProfessor(idDetails);
      this.blockForm();
    } else if (idUpdate != null) {
      this.action = 'UPDATE';
      this.loadProfessor(idUpdate);
    } else {
      this.action = 'ADD';
    }
    console.log(this.action);
    this.getProvinces();

  }
  submit() {
    if (this.form.invalid) return;
    let professor = new Professor();
    let userProfile = new UserProfile();
    userProfile.username = this.username.value;
    userProfile.password = this.password.value;
    userProfile.userPhoto = "image";
    userProfile.interests = this.interests.value;
    userProfile.email = this.email.value;
    userProfile.admin = false;
    userProfile.isEnable= true;
    let canton = new Canton();
    canton.idCanton=this.canton.value;
    let province = new Province();
    province.idProvince=this.province.value;
    let district = new District();
    district.idDistrict=this.district.value;
    userProfile.canton = canton;
    userProfile.province = province;
    userProfile.district = district;
    userProfile.creationDate = new Date();
    professor.userProfile = userProfile;
    professor.degree = this.degree.value;
    console.log(professor);
    if (this.action == 'ADD') {
      this.service.save(professor).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success professor add'
        }).finally(() => {
          this.router.navigate(['/professor-list'])
        });
      }, res => {
        swal.fire({
          icon: 'error',
          text: 'Failed, please try again'
        });
      });
    } else if (this.action == 'UPDATE') {
      professor.userProfile.idUserProfile = this.route.snapshot.params['idUpdate'];
      this.service.update(professor).subscribe(data => {
        swal.fire({
          icon: 'success',
          text: 'Success professor update'
        }).finally(() => {
          this.router.navigate(['/professor-list'])
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

  getProvinces() {
    this.provinces = [];
    this.generalService.getProvinces().subscribe((data: {}) => {
      console.log(data);
      this.provinces = data;
    })
  }

  cancel() {
    this.router.navigate(['/']);
  }

  getCantons(id: number) {
    this.cantons = [];
    this.generalService.getCantos(id).subscribe((data: {}) => {
      console.log(data);
      this.cantons = data;
    })
  }

  getDistricts(id: number) {
    this.districts = [];
    this.generalService.getDistricts(id).subscribe((data: {}) => {
      console.log(data);
      this.districts = data;
    })
  }

  provinceSelectOnChange(id) {
    this.getCantons(id);
  }

  cantonSelectOnChange(id) {
    this.getDistricts(id);
  }

  loadProfessor(id: number) {
    let professor: any = {};
    this.service.findById(id).subscribe((data: {}) => {
      professor = data;
      console.log(data);
      this.form.controls['username'].setValue(professor.userProfile.username);
      this.form.controls['password'].setValue(professor.userProfile.password);
      this.form.controls['email'].setValue(professor.userProfile.email);
      this.form.controls['interests'].setValue(professor.userProfile.interests);
      this.form.controls['province'].setValue(professor.userProfile.province.idProvince);
      this.form.controls['canton'].setValue(professor.userProfile.canton.idCanton);
      this.getCantons(professor.userProfile.province.idProvince);
      this.getDistricts(professor.userProfile.canton.idCanton);
      this.form.controls['district'].setValue(professor.userProfile.district.idDistrict);
      this.form.controls['degree'].setValue(professor.degree);
    });
  }
  get username() { return this.form.get('username'); }
  get password() { return this.form.get('password'); }
  get email() { return this.form.get('email'); }
  get interests() { return this.form.get('interests'); }
  get canton() { return this.form.get('canton'); }
  get province() { return this.form.get('province'); }
  get district() { return this.form.get('district'); }
  get degree() { return this.form.get('degree'); }

}
