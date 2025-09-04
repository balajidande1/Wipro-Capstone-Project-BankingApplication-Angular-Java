import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { AccountService } from './services/account.service';
import { TransactionService } from './services/transaction.service';
import { PaymentService } from './services/payment.service';
import { CommonModule } from '@angular/common'; 
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CustomerService } from './services/customer.service';
import { BrowserModule } from '@angular/platform-browser';
import { AccountListComponent } from "./components/account/account-list/account-list.component";
import { CustomerListComponent } from "./components/customer/customer-list/customer-list.component";
import { PaymentListComponent } from "./components/payment/payment-list/payment-list.component";
import { TransactionListComponent } from "./components/transaction/transaction-list/transaction-list.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, ReactiveFormsModule, AccountListComponent, CustomerListComponent, PaymentListComponent, TransactionListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Banking-Application Frontend';

    constructor(
    public customerService: CustomerService,
    public accountService: AccountService,
    public transactionService: TransactionService,
    public paymentService: PaymentService
  ) {}



  
}
