import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpErrorResponse,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';

import {catchError, Observable, throwError} from 'rxjs';
//TODO ???????
@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor{
intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<unknown>> {
  return next.handle(request).pipe(
    catchError((error: HttpErrorResponse) => {
      let errorMsg = '';
      if (error.error instanceof ErrorEvent) {
      console.log('This is client side error');
        errorMsg = `Error: ${error.error.message}`;
        alert(error.error)
      } else {
      console.log('This is server side error');
        errorMsg = `Error Code: ${error.status},  Message: ${error.message}`;
        alert(error.error)
      }
    console.log(errorMsg);
      return throwError(errorMsg);
    })
  )
}
}
