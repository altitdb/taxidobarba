import { Component, OnInit } from "@angular/core";
import { CityService } from "./city.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { DriverService } from "../service/driver.service";
import { CarService } from "../service/car.service";
import * as moment from 'moment';
import { ModalController } from "@ionic/angular";
import { ModalPage } from "./modal/modal.page";

@Component({
  selector: "app-city",
  templateUrl: "./city.page.html",
  styleUrls: ["./city.page.scss"]
})
export class CityPage implements OnInit {
  drivers: Array<Driver>;
  cars: Array<Car>;
  form: FormGroup;

  constructor(
    private _driverService: DriverService,
    private _carService: CarService,
    private _formBuilder: FormBuilder,
    private _cityService: CityService,
    private _modalController: ModalController
  ) {}

  ngOnInit() {
    this.form = this._formBuilder.group({
      date: [new Date().toISOString(), Validators.required],
      driver: [null, Validators.required],
      car: [null, Validators.required],
      startKm: [null, Validators.required],
      endKm: [null, Validators.required],
      otherKm: [null, Validators.required],
      totalReceived: [null, Validators.required]
    });
    this.getDrivers();
    this.getCars();
  }

  save() {
    this.form.value.date = moment(this.form.value.date).format('YYYY-MM-DD');
    this._cityService.save(this.form.value).subscribe(suc => {
      this.presentModal(suc);
      this.form.reset();
    });
  }

  async presentModal(response: CityResponse) {
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
