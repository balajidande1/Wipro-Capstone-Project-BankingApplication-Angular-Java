import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class CustomerService {
  private baseUrl = environment.customerServiceUrl;


  constructor(private http: HttpClient) {}

getAllCustomers(): Observable<any[]> {
  return this.http.get<any[]>(`${this.baseUrl}/getAllCustomers`);
}

addCustomer(customer: any): Observable<any> {
  return this.http.post(`${this.baseUrl}/createCustomer`, customer);
}

getCustomerById(id: number): Observable<any> {
  return this.http.get(`${this.baseUrl}/${id}`);
}

deleteCustomer(id: number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/deleteCustomer/${id}`);
}

  patchCustomer(id: number, customer: any): Observable<any> {
    return this.http.patch(`${this.baseUrl}/patchCustomer/${id}`, customer);
  }

}
