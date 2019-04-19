import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { TravelPage } from './travel.page';
import { HttpClientModule } from '@angular/common/http';
import { DriverService } from '../service/driver.service';
import { CarService } from '../service/car.service';
import { TravelService } from './travel.service';

const routes: Routes = [
  {
    path: '',
    component: TravelPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [TravelPage],
  providers: [
    TravelService,
    DriverService,
    CarService,
  ]
})
export class TravelPageModule {}
