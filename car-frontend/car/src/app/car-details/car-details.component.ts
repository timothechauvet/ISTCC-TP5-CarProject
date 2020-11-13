import { Component, OnInit, Input } from '@angular/core';
import { CarService } from '../car.service';
import { Car } from '../car';
 
import { CarsListComponent } from '../cars-list/cars-list.component';
 
@Component({
  selector: 'car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {
 
  @Input() car: Car;
 
  constructor(private carService: CarService, private listComponent: CarsListComponent) { }
 
  ngOnInit() {
  }
 
  updateRented(isRented: boolean) {
    this.carService.updateCar(this.car.id,
      { plateNumber: this.car.plateNumber, rented: isRented })
      .subscribe(
        data => {
          console.log(data);
          this.car = data as Car;
        },
        error => console.log(error));
  }
 
  deleteCar() {
    this.carService.deleteCar(this.car.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}