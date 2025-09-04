import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class TransactionService {
  private baseUrl = `${environment.apiBaseUrl}/api/transactions`;

  constructor(private http: HttpClient) {}

  createTransaction(transaction: any):Observable<any>{
    return this.http.post('${this.baseUrl}/create', transaction);
  }

  getAllTransactions():Observable<any[]>{
    return this.http.get<any[]>('${this.baseUrl}/getAllTransactions');
  }

  getTransactionById(id: number): Observable<any>{
    return this.http.get('${this.baseUrl}/${id}');
  }
  patchTransaction(id: number, partialUpdate: any): Observable<any>{
    return this.http.patch('${this.baseUrl}/${id}/status', partialUpdate)
  }

 
}
