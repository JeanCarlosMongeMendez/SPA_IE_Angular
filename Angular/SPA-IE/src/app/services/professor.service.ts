import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from "rxjs";
import { Professor } from '../model/professor';


@Injectable({
    providedIn: 'root'
})
export class ProfessorService {
    private _url = 'http://localhost:8080/spa_war/api/professor/';

    constructor(private http: HttpClient) { }

    public save(professor: Professor): Observable<any> {
        return this.http.post<any>(this._url, professor);
      }
    
      public findById(idUserProfile: number): Observable<any>{
        return this.http.get<any>(this._url+idUserProfile);
      }
    
      public listAll(): Observable<any>{
        return this.http.get<any>(this._url);
      }
    
      public update(professor: Professor): Observable<any>{
          return this.http.put<any>(this._url+professor.userProfile.idUserProfile, professor);
      }
    
      public delete(idUserProfile: number): Observable<any>{
          return this.http.delete<any>(this._url + idUserProfile);
      }




}