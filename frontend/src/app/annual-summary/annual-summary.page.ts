import { Component, OnInit } from '@angular/core';
import { AnnualSummaryService } from './annual-summary.service';

@Component({
  selector: 'app-annual-summary',
  templateUrl: './annual-summary.page.html',
  styleUrls: ['./annual-summary.page.scss'],
})
export class AnnualSummaryPage implements OnInit {

  report: Array<AnnualSummaryItem>;
  amount: AmountAnnualSummary;

  constructor(private _annualSummaryService: AnnualSummaryService) { }

  ngOnInit() {
    this.getReport();
  }

  getReport() {
    this._annualSummaryService.get().subscribe(suc => {
      this.report = suc.annualSummary;
      this.amount = suc.amount;
    });
  }

}
