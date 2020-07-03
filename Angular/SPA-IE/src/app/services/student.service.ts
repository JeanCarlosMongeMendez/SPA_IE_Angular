import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Student } from "../model/Student";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class StudentService {
  private _url='http://localhost:8080/api/student/';

  constructor(private http: HttpClient) { }

  public save(student: Student): Observable<any> {
    return this.http.post<any>(this._url, student);
  }

  public findById(id: number): Observable<any>{
    return this.http.get<any>(this._url+id);
  }

  public list(): Observable<any>{
    return this.http.get<any>(this._url);
  }

  public update(student: Student): Observable<any>{
      return this.http.put<any>(this._url+student.userProfile.idUserProfile, student);
  }

  public delete(id: number): Observable<any>{
      return this.http.delete<any>(this._url + id);
  }

  getProvinces() {
    return this.http.get(this._url + '/provinces/');
}

getCantos(id: number) {
    return this.http.get(this._url + '/cantons/' + id);
}

getDistricts(id: number) {
    return this.http.get(this._url + '/districts/' + id);
}

}