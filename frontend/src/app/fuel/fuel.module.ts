import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { FuelPage } from './fuel.page';
import { FuelService } from './fuel.service';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';

const routes: Routes = [
  {
    path: '',
    component: FuelPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule
  ],
  declarations: [FuelPage],
  providers: [
    FuelService,
    DriverService,
    CarService
  ]
})
export class FuelPageModule {}
