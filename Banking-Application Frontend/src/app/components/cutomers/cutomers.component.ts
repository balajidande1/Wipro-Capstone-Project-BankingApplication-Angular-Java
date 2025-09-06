import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Customer } from './customer.model';
import { CustomerService } from '../services/customer.service';


@Component({
  selector: 'app-customer-list',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './cutomers.component.html',
  styleUrl: './cutomers.component.css'
})
export class CustomerComponent implements OnInit {
    customers: Customer[] = [];
  newCustomer: Customer = {} as Customer;
  selectedCustomer: Customer | null = null;
  searchEmail: string = '';

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getAllCustomers().subscribe({
      next: (data) => this.customers = data,
      error: (err) => console.error('Error fetching customers:', err)
    });
  }

  saveCustomer(): void {
    if (!this.newCustomer.customerId) {
      // Add
      this.customerService.addCustomer(this.newCustomer).subscribe({
        next: () => {
          this.loadCustomers();
          this.clearForm();
        },
        error: (err) => console.error('Error adding customer:', err)
      });
    } else {
      // Patch (update)
      this.customerService.patchCustomer(this.newCustomer.customerId, this.newCustomer).subscribe({
        next: () => {
          this.loadCustomers();
          this.clearForm();
        },
        error: (err) => console.error('Error updating customer:', err)
      });
    }
  }

  deleteCustomer(id: number): void {
    this.customerService.deleteCustomer(id).subscribe({
      next: () => this.loadCustomers(),
      error: (err) => console.error('Error deleting customer:', err)
    });
  }

  viewCustomer(customer: Customer): void {
    this.selectedCustomer = customer;
  }

  editCustomer(customer: Customer): void {
    this.newCustomer = { ...customer };
  }

  patchCustomer(id: number, changes: any): void {
    this.customerService.patchCustomer(id, changes).subscribe({
      next: () => this.loadCustomers(),
      error: (err) => console.error('Error patching customer:', err)
    });
  }

  searchCustomer(): void {
    if (!this.searchEmail) {
      this.loadCustomers();
      return;
    }

    const customer = this.customers.find(c => c.email === this.searchEmail);
    if (customer) {
      this.customers = [customer];
    } else {
      this.customers = [];
    }
  }

  clearForm(): void {
    this.newCustomer = {} as Customer;
  }

  clearSearch(): void {
    this.searchEmail = '';
    this.loadCustomers();
  }
}
