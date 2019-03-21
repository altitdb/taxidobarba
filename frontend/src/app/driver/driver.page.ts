import { Component, OnInit } from '@angular/core';
import { DriverService } from './driver.service';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.page.html',
  styleUrls: ['./driver.page.scss'],
})
export class DriverPage implements OnInit {

  public drivers: Array<Driver>;

  constructor(private _driverService: DriverService) { }

  ngOnInit() {
    this.getDrivers();
  }

  getDrivers() {
    this._driverService.get()
       .subscribe(suc => {
          this.drivers = suc
        });
  }

}
