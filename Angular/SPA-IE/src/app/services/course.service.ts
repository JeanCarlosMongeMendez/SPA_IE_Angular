import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Course} from "../model/course";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class CourseService {
  private _url='http://localhost:8282/spa_war/api/course';

  constructor(private http: HttpClient) { }

  createCourse(course: Course): Observable<any> {
    return this.http.post<any>(this._url, course);
  }

  public findById(courseId: number): Observable<any>{
    return this.http.get<any>(this._url+"/"+courseId);
  }

  public getCourses(): Observable<any>{
    return this.http.get(this._url);
  }
}