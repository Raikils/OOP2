import { KeycloakService} from "keycloak-angular";
import {Component, OnInit} from "@angular/core";
import {Request} from "../request";
import {RequestService} from "../request.service";



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['../admin/admin.component.scss']
})

export class UserComponent implements OnInit{

  userName =' ';
  requests: Request[] = [];
  constructor(private keycloakService: KeycloakService, private requestService: RequestService) {}

  ngOnInit(): void {
    this.initializeUserOptions();
  }

  private initializeUserOptions(): void {
    this.userName = this.keycloakService.getUsername();
    this.fetchRequests();
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

}
