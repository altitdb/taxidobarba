import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { FuelPage } from './fuel.page';
import { FuelService } from './fuel.service';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';
import { ModalPageModule } from './modal/modal.module';
import { ModalPage } from './modal/modal.page';

const routes: Routes = [
  {
    path: '',
    component: FuelPage
  },
  {
    path: ':id',
    component: FuelPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
    ModalPageModule
  ],
  declarations: [FuelPage],
  providers: [
    FuelService,
    DriverService,
    CarService
  ],
  entryComponents: [
    ModalPage
  ]
})
export class FuelPageModule {}
