import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Car } from './car';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private baseUrl = 'http://localhost:8080/api/cars';

  constructor(private http: HttpClient) { }

  getVehicle(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  createVehicle(Vehicle: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, Vehicle);
  }
 
  updateVehicle(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteVehicle(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
 
  getVehiclesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  // cars: Car[] = CARS;

  // getCarsWithPromise(): Promise<Car[]> {
  //   return Promise.resolve(this.cars);
  // }

  // rent(car: Car){
  //   const index = this.cars.findIndex(obj => obj.plateNumber === car.plateNumber);
  //   console.warn(car.plateNumber);
  //   if (index > -1 && car.rented == false) {
  //     this.cars[index].rented = true;
  //   }
  // }

  // //Append with a new car
  // give(car: Car){
  //   const index = this.cars.findIndex(obj => obj.plateNumber === car.plateNumber);
  //   console.warn(car.plateNumber);
  //   if (index > -1 && car.rented == true) {
  //     this.cars[index].rented = false;
  //   }
  // }

}
