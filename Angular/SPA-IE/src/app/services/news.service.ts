import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

const endpoint = 'https://localhost:44357/api/news/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  constructor(private http: HttpClient) {


  }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

 

  getNews(): Observable<any> {
    return this.http.get(endpoint + 'GetAllNewsSP').pipe(
      map(this.extractData),
      catchError(this.handleError<any>('getNews'))
      );
  }


  /*getNewsById(id): Observable<any> {
    return this.http.get(endpoint + 'news/GetNews/' + id).pipe(
      map(this.extractData),
      catchError(this.handleError<any>('getNewsById'))
      );
  }

  addNews (news): Observable<any> {
    console.log(news);
    return this.http.post<any>(endpoint + 'news/PostNews/', JSON.stringify(news), httpOptions).pipe(
      tap((news) => console.log('added news')),
      catchError(this.handleError<any>('addNews'))
    );
  }

  deleteNews (id): Observable<any> {
    return this.http.delete<any>(endpoint + 'news/DeleteNews/' + id, httpOptions).pipe(
      tap(_ => console.log(`deleted news id=${id}`)),
      catchError(this.handleError<any>('deleteNews'))
    );
  }

  updateNews (news): Observable<any> {
    return this.http.put(endpoint + 'news/PutNews', JSON.stringify(news), httpOptions).pipe(
      tap((news) => console.log('updated news')),
      catchError(this.handleError<any>('updateNews'))
    );
  }
*/
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
