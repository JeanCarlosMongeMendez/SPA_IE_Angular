import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Course} from "../model/course";
import {Observable, of} from "rxjs";
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private _url='http://localhost:8282/spa_war/api/course/';

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

  public deleteCourse (id): Observable<any> {
    return this.http.delete<any>(this._url + id).pipe(
      tap(_ => console.log(`deleted course id=${id}`)),
      catchError(this.handleError<any>('deletecourse'))
    );
  }
  
  updateCourse (course): Observable<any> {
    return this.http.put(this._url + '/',  JSON.stringify(course)).pipe(
      tap((student) => console.log('updated course')),
      catchError(this.handleError<any>('updateCourse'))
    );
  }
  
  //ERROR
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}