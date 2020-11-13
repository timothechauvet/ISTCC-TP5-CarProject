import { Component, OnInit } from '@angular/core';
 
import { Car } from '../car';
import { CarService } from '../car.service';
 
@Component({
  selector: 'create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {
 
  car: Car = new Car();
  submitted = false;
 
  constructor(private carService: CarService) { }
 
  ngOnInit() {
  }
 
  newCar(): void {
    this.submitted = false;
    this.car = new Car();
  }
 
  save() {
    this.carService.createCar(this.car)
      .subscribe(data => console.log(data), error => console.log(error));
    this.car = new Car();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  }
}