import { Component, OnInit } from "@angular/core";
import { DailyService } from "./daily.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { DriverService } from "../service/driver.service";
import { CarService } from "../service/car.service";

@Component({
  selector: "app-daily",
  templateUrl: "./daily.page.html",
  styleUrls: ["./daily.page.scss"]
})
export class DailyPage implements OnInit {
  drivers: Array<Driver>;
  cars: Array<Car>;
  form: FormGroup;
  response: CityResponse;

  constructor(
    private _driverService: DriverService,
    private _carService: CarService,
    private _formBuilder: FormBuilder,
    private _dailyService: DailyService
  ) {}

  ngOnInit() {
    this.form = this._formBuilder.group({
      date: [new Date(), Validators.required],
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
    this._dailyService.save(this.form.value).subscribe(suc => {
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
