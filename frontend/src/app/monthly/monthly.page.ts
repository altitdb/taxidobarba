import { Component, OnInit } from '@angular/core';
import { MonthlyService } from './monthly.service';
import * as moment from 'moment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-monthly',
  templateUrl: './monthly.page.html',
  styleUrls: ['./monthly.page.scss'],
})
export class MonthlyPage implements OnInit {

  datetime: string = new Date().toISOString();
  report: Array<MonthlyReportItem>;
  amount: Amount;

  constructor(private _monthlyService: MonthlyService,
    private _router: Router) { }

  ngOnInit() {
    this.getDrivers();
  }

  getDrivers() {
    const month = moment(this.datetime).format("MM");
    const year = moment(this.datetime).format("YYYY");
    this._monthlyService.get(month, year)
       .subscribe(suc => {
          this.report = suc.report;
          this.amount = suc.amount;
        });
  }

  update(id, type) {
    if (type === 'CITY') {
      this._router.navigateByUrl(`/city/${id}`);
    } else if (type === 'TRAVEL') {
      this._router.navigateByUrl(`/travel/${id}`);
    } else if (type === 'FUEL') {
      this._router.navigateByUrl(`/fuel/${id}`);
    }
  }

  filterDate() {
    this.getDrivers();
  }
}
