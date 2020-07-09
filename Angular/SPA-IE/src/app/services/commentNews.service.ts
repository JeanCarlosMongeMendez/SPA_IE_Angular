import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

const endpoint = 'https://localhost:44357/api/comment/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CommentNewsService {
  constructor(private http: HttpClient) {


  }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

 

  getComment(): Observable<any> {
    return this.http.get(endpoint + 'GetAllCommentSP').pipe(
      map(this.extractData),
      catchError(this.handleError<any>('getComment'))
      );
  }


  getCommentById(id): Observable<any> {
    return this.http.get(endpoint + 'GetComment/' + id).pipe(
      map(this.extractData),
      catchError(this.handleError<any>('getCommentById'))
      );
  }

  addComment (comment): Observable<any> {
    console.log(comment);
    return this.http.post<any>(endpoint + 'PostComment/', JSON.stringify(comment), httpOptions).pipe(
      tap((news) => console.log('added comment')),
      catchError(this.handleError<any>('addComment'))
    );
  }

  deleteComment (id): Observable<any> {
    return this.http.delete<any>(endpoint + 'DeleteComment/' + id, httpOptions).pipe(
      tap(_ => console.log(`deleted comment id=${id}`)),
      catchError(this.handleError<any>('deleteComment'))
    );
  }

  updateComments (comment): Observable<any> {
    return this.http.put(endpoint + 'PutComment', JSON.stringify(comment), httpOptions).pipe(
      tap((comment) => console.log('updated comments')),
      catchError(this.handleError<any>('updateComments'))
    );
  }

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
