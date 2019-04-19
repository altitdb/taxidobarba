import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Routes, RouterModule } from "@angular/router";

import { IonicModule } from "@ionic/angular";

import { DailyPage } from "./daily.page";
import { DailyService } from "./daily.service";
import { HttpClientModule } from "@angular/common/http";
import { CarService } from "../service/car.service";
import { DriverService } from "../service/driver.service";

const routes: Routes = [
  {
    path: '',
    component: DailyPage
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
  declarations: [DailyPage],
  providers: [DailyService, DriverService, CarService]
})
export class DailyPageModule {}
