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

  singIn(values, type){
    if(type == 'student'){
      return this.http.get(this._url + 'student/login?username=' +values.username+'&password='+values.password);
    }else{
      return this.http.get(this._url + 'professor/login?username=' +values.username+'&password='+values.password);
    }
  }
}