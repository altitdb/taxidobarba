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
import { ModalPageModule } from './modal/modal.module';
import { ModalPage } from './modal/modal.page';

const routes: Routes = [
  {
    path: '',
    component: TravelPage
  },
  {
    path: ':id',
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
    HttpClientModule,
    ModalPageModule
  ],
  declarations: [TravelPage],
  providers: [
    TravelService,
    DriverService,
    CarService,
  ],
  entryComponents: [ModalPage]
})
export class TravelPageModule {}
