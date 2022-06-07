import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RoomService} from "./views/profile/room.service";
import {RequestService} from "./views/profile/request.service";
import {BookingService} from "./views/profile/booking.service";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import {initializeKeycloak} from "./utility/app.init";
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {DropDownListModule} from "@syncfusion/ej2-angular-dropdowns";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    KeycloakAngularModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DropDownListModule
  ],
  providers: [{
    provide: APP_INITIALIZER,
    useFactory: initializeKeycloak,
    multi: true,
    deps: [KeycloakService]
  },
    RoomService,
    RequestService,
    BookingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
