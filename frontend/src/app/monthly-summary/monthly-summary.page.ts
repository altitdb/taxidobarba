import { Component, OnInit } from '@angular/core';
import { MonthlySummaryService } from './monthly-summary.service';

@Component({
  selector: 'app-monthly-summary',
  templateUrl: './monthly-summary.page.html',
  styleUrls: ['./monthly-summary.page.scss'],
})
export class MonthlySummaryPage implements OnInit {

  report: MonthlySummary;

  constructor(private _monthlySummaryService: MonthlySummaryService) { }

  ngOnInit() {
    this.getReport();
  }

  getReport() {
    this._monthlySummaryService.get().subscribe(suc => {
      this.report = suc;
    });
  }

}
