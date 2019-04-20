import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';
import { TravelService } from './travel.service';

@Component({
  selector: 'app-travel',
  templateUrl: './travel.page.html',
  styleUrls: ['./travel.page.scss'],
})
export class TravelPage implements OnInit {

  form: FormGroup;
  response: TravelResponse;
  drivers: Array<Driver>;
  cars: Array<Car>;

  constructor(private _formBuilder: FormBuilder,
              private _travelService: TravelService,
              private _driverService: DriverService,
              private _carService: CarService) { }

  ngOnInit() {
    this.form = this._formBuilder.group({
      date: [new Date().toISOString(), Validators.required],
      driver: [null, Validators.required],
      car: [null, Validators.required],
      km: [null, Validators.required],
      price: [null, Validators.required],
      city: [null, Validators.required],
    });
    this.getDrivers();
    this.getCars();
  }

  save() {
    this._travelService.save(this.form.value).subscribe(suc => {
      this.response = suc;
    });
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
