import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Course} from "../model/course";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private _url='http://localhost:8282/spa_war/api/course/';

  constructor(private http: HttpClient) { }

  createCourse(course: Course): Observable<any> {
    return this.http.post<any>(this._url, course);
  }

  public findById(id: number): Observable<any> {
    return this.http.get<any>(this._url + id);
  }

  public list(): Observable<any> {
    return this.http.get<any>(this._url);
  }

  public update(course: Course): Observable<any> {
    return this.http.put<any>(this._url + course.courseId, course);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this._url + id);
  }


}