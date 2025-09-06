import { Injectable } from "@angular/core";

import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class PaymentService {
  private baseUrl = `http://localhost:8084/api/payment`;

  constructor(private http: HttpClient) {}

  // Get all payments
  getAllPayments(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getAllPayments`);
  }

  // Get payment by ID
  getPaymentById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // Create a new payment
  createPayment(payment: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/createPayment`, payment);
  }


  // Delete payment
  deletePayment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deletePayment/${id}`);
  }

  // Patch payment (update only specific fields like status)
  patchPayment(id: number, partialUpdate: any): Observable<any> {
    return this.http.patch(`${this.baseUrl}/patchPayment/${id}`, partialUpdate);
  }
}
