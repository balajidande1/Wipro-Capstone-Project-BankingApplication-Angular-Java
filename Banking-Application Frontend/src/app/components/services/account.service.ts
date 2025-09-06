import { Injectable } from "@angular/core";

import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class AccountService {
  getAllCustomers() {
    throw new Error('Method not implemented.');
  }
  private baseUrl = `http://localhost:8082/api/account`;

  constructor(private http: HttpClient) {}

 // Get all accounts
  getAllAccounts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getAllAccounts`);
  }

  // Get a specific account by ID
  getAccountById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // Create a new account
  addAccount(account: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/createAccount`, account);
  }

  // Update account
  updateAccount(id: number, account: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/patchAccount/${id}`, account);
  }

  // Delete account
  deleteAccount(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteAccount/${id}`);
  }

}
