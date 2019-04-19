import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: './tabs/tabs.module#TabsPageModule' },
  { path: 'driver', loadChildren: './driver/driver.module#DriverPageModule' },
  { path: 'city', loadChildren: './city/city.module#CityPageModule' },
  { path: 'travel', loadChildren: './travel/travel.module#TravelPageModule' },
  { path: 'fuel', loadChildren: './fuel/fuel.module#FuelPageModule' }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
