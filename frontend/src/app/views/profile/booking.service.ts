import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Request} from "./request";

@Injectable()
export class BookingService {

  _url : string = 'http://localhost:8085/demo_war_exploded/book';

  constructor(private http: HttpClient) {}

  postBook(idRoom: number, idRequest: number): void {
    const headers = {
      'content-type': 'application/json'
    };
    let body = JSON.stringify({idRoom: idRoom, idRequest: idRequest})
    console.log(body);
    this.http.post<any>(this._url, body, {'headers':headers}).subscribe();
  }


}
