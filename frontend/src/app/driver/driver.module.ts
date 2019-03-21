import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { DriverPage } from './driver.page';
import { HttpClientModule } from '@angular/common/http';

import { DriverService } from './driver.service';

const routes: Routes = [
  {
    path: '',
    component: DriverPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    HttpClientModule
  ],
  declarations: [DriverPage],
  providers: [
    DriverService
  ]
})
export class DriverPageModule {}
