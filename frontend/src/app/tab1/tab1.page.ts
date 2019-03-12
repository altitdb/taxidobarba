import { Component } from '@angular/core';
import { DriverService } from '../driver/driver.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  public drivers: Array<Driver>;

  constructor(private _driverService: DriverService) { }

  ngOnInit() {
    this.getDrivers();
  }

  getDrivers() {
    console.log("aqui");
    this._driverService.get()
       .subscribe(suc => {
          this.drivers = suc
        });
  }
}
