import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Request} from "./request";

@Injectable()
export class RequestService {

  _url : string = 'http://localhost:8085/demo_war_exploded/request';

  constructor(private http: HttpClient) {}

  fetchRequests(){
    return this.http.get<Request[]>(this._url);
  }
}
