import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { IonicModule } from '@ionic/angular';

import { TrafficTicketPage } from './traffic-ticket.page';
import { TrafficTicketService } from './traffic-ticket.service';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';

import { ModalPage } from "./modal/modal.page";
import { ModalPageModule } from "./modal/modal.module";

const routes: Routes = [
  {
    path: '',
    component: TrafficTicketPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
    HttpClientModule,
    ModalPageModule
  ],
  declarations: [TrafficTicketPage],
  providers: [TrafficTicketService, CarService, DriverService],
  entryComponents: [ModalPage]
})
export class TrafficTicketPageModule { }
