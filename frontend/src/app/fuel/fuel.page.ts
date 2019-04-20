import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CarService } from '../service/car.service';
import { DriverService } from '../service/driver.service';
import { FuelService } from './fuel.service';

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
    private _fuelService: FuelService
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
    this._fuelService.save(this.form.value).subscribe(suc => {
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
