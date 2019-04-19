import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Routes, RouterModule } from "@angular/router";

import { IonicModule } from "@ionic/angular";

import { CityPage } from "./city.page";
import { CityService } from "./city.service";
import { HttpClientModule } from "@angular/common/http";
import { CarService } from "../service/car.service";
import { DriverService } from "../service/driver.service";

const routes: Routes = [
  {
    path: '',
    component: CityPage
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
  declarations: [CityPage],
  providers: [CityService, DriverService, CarService]
})
export class CityPageModule {}
