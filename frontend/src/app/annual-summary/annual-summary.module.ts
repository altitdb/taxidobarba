import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { Routes, RouterModule } from "@angular/router";

import { IonicModule } from "@ionic/angular";

import { AnnualSummaryPage } from "./annual-summary.page";
import { AnnualSummaryService } from "./annual-summary.service";

const routes: Routes = [
  {
    path: "",
    component: AnnualSummaryPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [AnnualSummaryPage],
  providers: [AnnualSummaryService]
})
export class AnnualSummaryPageModule {}
