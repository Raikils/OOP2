import { KeycloakService} from "keycloak-angular";
import {Component, OnInit} from "@angular/core";
import {NgForm} from "@angular/forms";

import {Room} from "../room";
import {RoomService} from "../room.service";
import {Request} from "../request";
import {RequestService} from "../request.service";
import {BookingService} from "../booking.service";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})

export class AdminComponent implements OnInit{

  userName =' ';
  idRoom = 0;
  idRequest = 0;
  rooms: Room[] = [];
  requests: Request[] = [];
  constructor(private keycloakService: KeycloakService, private roomService: RoomService,
              private requestService: RequestService, private bookingService: BookingService) {}


  ngOnInit(): void {
    this.initializeUserOptions();
  }

  private initializeUserOptions(): void {
    this.userName = this.keycloakService.getUsername();
    this.fetchRooms();
    this.fetchRequests();
  }

  fetchRooms(){
    this.roomService.fetchRooms().subscribe(
      data =>{
        console.log(data);
        for (let room of data) {
          this.rooms.push(room);
        }
      }
    )
  }

  fetchRequests(){
    this.requestService.fetchRequests().subscribe(
      data =>{
        console.log(data);
        for (let request of data) {
          this.requests.push(request);
        }
      }
    )
  }


  logout(): void{
    this.keycloakService.logout('http://localhost:4200');
  }

  book(): void{
    this.bookingService.postBook(this.idRoom, this.idRequest);
  }

  inputHandlerRoom(event: any): void{
    const value = event.target.value;
    this.idRoom = value;
  }

  inputHandlerRequest(event: any): void{
    const value = event.target.value;
    this.idRequest = value;
  }

};
