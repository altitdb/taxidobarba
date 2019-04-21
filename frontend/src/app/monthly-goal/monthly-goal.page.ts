import { Component, OnInit } from '@angular/core';
import { MonthlyGoalService } from './monthly-goal.service';

@Component({
  selector: 'app-monthly-goal',
  templateUrl: './monthly-goal.page.html',
  styleUrls: ['./monthly-goal.page.scss'],
})
export class MonthlyGoalPage implements OnInit {

  report: Array<MonthlyGoalItem>;
  summary: MonthGoalSummary;

  constructor(private _monthlyGoalService: MonthlyGoalService) { }

  ngOnInit() {
    this.getReport();
  }

  getReport() {
    this._monthlyGoalService.get().subscribe(suc => {
      this.report = suc.goal;
      this.summary = suc.summary;
    });
  }

}
