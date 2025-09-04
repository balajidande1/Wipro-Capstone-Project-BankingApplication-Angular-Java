import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { AccountListComponent } from './components/account/account-list/account-list.component';
import { TransactionListComponent } from './components/transaction/transaction-list/transaction-list.component';
import { PaymentListComponent } from './components/payment/payment-list/payment-list.component';
import { Component, NgModule } from '@angular/core';
import { AppComponent } from './app.component';


export const routes: Routes = [
   { path: '', redirectTo: 'customers', pathMatch: 'full' },
      { path: 'customers', component: CustomerListComponent },
  { path: 'accounts', component: AccountListComponent },
  { path: 'transactions', component: TransactionListComponent },
  { path: 'payments', component: PaymentListComponent },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}