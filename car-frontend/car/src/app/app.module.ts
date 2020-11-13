import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
 
import { AppComponent } from './app.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { CarsListComponent } from './cars-list/cars-list.component';
import { SearchCarsComponent } from './search-cars/search-cars.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
 
@NgModule({
  declarations: [
    AppComponent,
    CreateCarComponent,
    CarDetailsComponent,
    CarsListComponent,
    SearchCarsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }