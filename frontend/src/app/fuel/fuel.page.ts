import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';
import { FuelService } from './fuel.service';
import * as moment from 'moment';
import { ModalController } from "@ionic/angular";
import { ModalPage } from "./modal/modal.page";

@Component({
  selector: 'app-fuel',
  templateUrl: './fuel.page.html',
  styleUrls: ['./fuel.page.scss'],
})
export class FuelPage implements OnInit {

  drivers: Array<Driver>;
  cars: Array<Car>;
  form: FormGroup;
  response: FuelResponse;

  constructor(
    private _driverService: DriverService,
    private _carService: CarService,
    private _formBuilder: FormBuilder,
    private _fuelService: FuelService,
    private _modalController: ModalController
  ) {}

  ngOnInit() {
    this.form = this._formBuilder.group({
      date: [new Date().toISOString(), Validators.required],
      driver: [null, Validators.required],
      car: [null, Validators.required],
      km: [null, Validators.required],
      price: [null, Validators.required],
      liters: [null, Validators.required],
    });
    this.getDrivers();
    this.getCars();
  }

  save() {
    this.form.value.date = moment(this.form.value.date).format('YYYY-MM-DD');
    this._fuelService.save(this.form.value).subscribe(suc => {
      this.presentModal(suc);
      this.form.reset();
    });
  }

  async presentModal(response: FuelResponse) {
    const modal = await this._modalController.create({
      component: ModalPage,
      componentProps: { response }
    });
    return await modal.present();
  }


  getDrivers() {
    this._driverService.getActive().subscribe(suc => {
      this.drivers = suc;
    });
  }

  getCars() {
    this._carService.getActive().subscribe(suc => {
      this.cars = suc;
    });
  }

}
