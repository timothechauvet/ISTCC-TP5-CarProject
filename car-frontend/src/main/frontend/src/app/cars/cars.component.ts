import { Component, OnInit } from '@angular/core';

import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {
  cars: Car[];
  selectedCar: Car;
  view = 'none';

  constructor(private carService: CarService) { }

  //Buttons
  onSelectRent(): void {
    this.selectedCar = null;
    this.view = 'rent';
  }

  onSelectGive(): void {
    this.selectedCar = null;
    this.view = 'give';
  }
  
  //Init
  ngOnInit(): void {
    this.getCars();
  }

  getCars(): void {
    this.carService.getCarsWithPromise().then(cars => this.cars = cars);
  }

  //Select
  onSelect(car: Car): void {
    console.warn(car);
    this.selectedCar = car;
  }

  //Operations
  rent(car: Car): void {
    console.warn(car);
    this.carService.rent(car);
  }
  
  give(car: Car): void {
    console.warn(car);
    this.carService.give(car);
  }
}
