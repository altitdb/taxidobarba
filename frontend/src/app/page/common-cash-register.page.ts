import { CarService } from "../service/car.service";
import { DriverService } from "../service/driver.service";
import { Component } from "@angular/core";

@Component({
  selector: "app-common-cash-register"
})
export class CommonCashRegister {
  protected drivers: Array<Driver>;
  protected cars: Array<Car>;

  constructor(
    public _driverService: DriverService,
    public _carService: CarService
  ) {}

  formatObject(object) {
    if (object === null) {
      return null;
    }
    return object.id;
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
