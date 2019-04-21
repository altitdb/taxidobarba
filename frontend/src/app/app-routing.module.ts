import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: './tabs/tabs.module#TabsPageModule' },
  { path: 'driver', loadChildren: './driver/driver.module#DriverPageModule' },
  { path: 'city', loadChildren: './city/city.module#CityPageModule' },
  { path: 'travel', loadChildren: './travel/travel.module#TravelPageModule' },
  { path: 'fuel', loadChildren: './fuel/fuel.module#FuelPageModule' },
  { path: 'monthly', loadChildren: './monthly/monthly.module#MonthlyPageModule' },
  { path: 'annual-summary', loadChildren: './annual-summary/annual-summary.module#AnnualSummaryPageModule' },
  { path: 'monthly-summary', loadChildren: './monthly-summary/monthly-summary.module#MonthlySummaryPageModule' },
  { path: 'monthly-goal', loadChildren: './monthly-goal/monthly-goal.module#MonthlyGoalPageModule' },
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
