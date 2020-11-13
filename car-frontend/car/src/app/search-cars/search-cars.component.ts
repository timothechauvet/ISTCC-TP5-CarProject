import { Component, OnInit } from '@angular/core';
import { Car } from '../car';
import { CarService } from '../car.service';
 
@Component({
  selector: 'search-cars',
  templateUrl: './search-cars.component.html',
  styleUrls: ['./search-cars.component.css']
})
export class SearchCarsComponent implements OnInit {
 
  plateNumber: string;
  cars: Car[];
 
  constructor(private dataService: CarService) { }
 
  ngOnInit() {
    this.plateNumber = 'default plate';
  }
 
  private searchCars() {
    this.dataService.getCarsByPlateNumber(this.plateNumber)
      .subscribe(cars => this.cars = cars);
  }
 
  onSubmit() {
    this.searchCars();
  }
}