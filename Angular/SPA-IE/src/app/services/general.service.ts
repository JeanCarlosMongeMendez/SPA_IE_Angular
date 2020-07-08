import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Student } from '../model/Student';

@Injectable({
  providedIn: 'root'
})

export class GeneralService {

  private _url = 'http://localhost:8282/spa_war/api/';

  constructor(private http: HttpClient) { }

  getProvinces() {
    return this.http.get(this._url + 'province/');
  }

  getCantos(id: number) {
    return this.http.get(this._url + 'canton/' + id);
  }

  getDistricts(id: number) {
    return this.http.get(this._url + 'district/' + id);
  }

  singIn(student: Student){
    return this.http.get(this._url + 'login/student?username=' +student.username+'&password='+student.password);
  }

}