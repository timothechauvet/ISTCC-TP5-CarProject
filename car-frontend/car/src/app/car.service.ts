import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class CarService {
 
  private baseUrl = 'http://localhost:8080/api/cars';
 
  constructor(private http: HttpClient) { }
 
  getCar(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  createCar(car: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, car);
  }
 
  updateCar(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteCar(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
 
  getCarsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
 
  getCarsByPlateNumber(plateNumber: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/plateNumber/${plateNumber}`);
  }
 
  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}