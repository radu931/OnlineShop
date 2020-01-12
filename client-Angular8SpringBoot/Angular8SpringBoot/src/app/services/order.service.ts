import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8080/api/orders';

  constructor(private http: HttpClient) { }

  getOrder(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createOrder(product: any): Observable<any> {
    return this.http.post(this.baseUrl, product);
  }

  updateOrder(id: number, value: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteOrder(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getOrdersList(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getOrdersByCustomerName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${name}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(this.baseUrl);
  }
}
