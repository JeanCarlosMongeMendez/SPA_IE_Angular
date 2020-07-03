import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Student } from "../model/student";
import { Observable, of } from "rxjs";
import { map, catchError, tap } from 'rxjs/operators';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
};

@Injectable({
    providedIn: 'root'
})

export class StudentService {
    private _url = 'http://localhost:8282/spa_war/api/student/';

    constructor(private http: HttpClient) { }

    private extractData(res: Response) {
        let body = res;
        return body || {};
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log(`${operation} failed: ${error.message}`);
            return of(result as T)
        }
    }

    getStudents(): Observable<any> {
        return this.http.get(this._url).pipe(
            map(this.extractData),
            catchError(this.handleError<any>('getStudents'))
        );
    }

    getStudent(id): Observable<any> {
        return this.http.get(this._url + id).pipe(
            map(this.extractData),
            catchError(this.handleError<any>('GetStudentById'))
        );
    }

    addStudent(Student): Observable<any> {
        console.log(Student);
        return this.http.post<any>(this._url, JSON.stringify(Student), httpOptions).pipe(
            tap((student) => console.log('added student')),
            catchError(this.handleError<any>('addStudent'))
        );
    }

    deleteStudent(id): Observable<any> {
        return this.http.delete<any>(this._url + id, httpOptions).pipe(
            tap(_ => console.log(`deleted student id = ${id}`)),
            catchError(this.handleError<any>('deleteStudent'))
        );
    }

    updateStudent(Student): Observable<any> {
        console.log(Student);
        return this.http.put<any>(this._url + Student.id, JSON.stringify(Student), httpOptions).pipe(
            tap((student) => console.log('added updated')),
            catchError(this.handleError<any>('updateStudent'))
        );
    }
}