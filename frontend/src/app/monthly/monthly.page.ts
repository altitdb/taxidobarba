import { Component, OnInit } from '@angular/core';
import { MonthlyService } from './monthly.service';
import * as moment from 'moment';

@Component({
  selector: 'app-monthly',
  templateUrl: './monthly.page.html',
  styleUrls: ['./monthly.page.scss'],
})
export class MonthlyPage implements OnInit {

  datetime: string = new Date().toISOString();
  report: Array<MonthlyReportItem>;
  amount: Amount;

  constructor(private _monthlyService: MonthlyService) { }

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

  filterDate() {
    this.getDrivers();
  }
}
