import { Component, OnInit } from '@angular/core';
import { MonthlyService } from './monthly.service';

@Component({
  selector: 'app-monthly',
  templateUrl: './monthly.page.html',
  styleUrls: ['./monthly.page.scss'],
})
export class MonthlyPage implements OnInit {

  report: Array<MonthlyReportItem>;
  amount: number;

  constructor(private _monthlyService: MonthlyService) { }

  ngOnInit() {
    this.getDrivers();
  }

  getDrivers() {
    this._monthlyService.get()
       .subscribe(suc => {
          this.report = suc.report;
          this.amount = suc.amount.amount;
        });
  }


}
