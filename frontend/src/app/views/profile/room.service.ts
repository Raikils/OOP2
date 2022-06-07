import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Room} from "./room";

@Injectable()
export class RoomService {

  _url : string = 'http://localhost:8085/demo_war_exploded/room';

  constructor(private http: HttpClient) {}

  fetchRooms(){
    return this.http.get<Room[]>(this._url);
  }
}
