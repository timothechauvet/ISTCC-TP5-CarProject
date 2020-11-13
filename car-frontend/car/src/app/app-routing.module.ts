import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarsListComponent } from './cars-list/cars-list.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { SearchCarsComponent } from './search-cars/search-cars.component';
 
const routes: Routes = [
    { path: '', redirectTo: 'car', pathMatch: 'full' },
    { path: 'car', component: CarsListComponent },
    { path: 'add', component: CreateCarComponent },
    { path: 'findbyplatenumber', component: SearchCarsComponent },
];
 
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
 
export class AppRoutingModule { }