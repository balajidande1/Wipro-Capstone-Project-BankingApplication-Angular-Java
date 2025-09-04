import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { PaymentService } from '../../../services/payment.service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment-list',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './payment-list.component.html',
  styleUrl: './payment-list.component.css'
})
export class PaymentListComponent {
    paymentForm!: FormGroup;
  payments: any[] = [];
  selectedPayment: any = null;
  searchId: number | null = null;

  constructor(private fb: FormBuilder, private paymentService: PaymentService) {}

  ngOnInit(): void {
    this.paymentForm = new FormGroup({
      transactionId: new FormControl('', [Validators.required]),
      method: new FormControl('', [Validators.required]),
      amount: new FormControl('', [Validators.required, Validators.min(1)]),
      currency: new FormControl('', [Validators.required]),
      status: new FormControl('PENDING', [Validators.required]),
      externalReferenceId: new FormControl(''),
      failureReason: new FormControl('')
    });

    this.getAllPayments();
  }

  // Create new payment
  onSubmit(): void {
    if (this.paymentForm.valid) {
      this.paymentService.createPayment(this.paymentForm.value).subscribe(
        res => {
          alert('✅ Payment created successfully!');
          this.paymentForm.reset({ status: 'PENDING' });
          this.getAllPayments();
        },
        err => console.error(err)
      );
    }
  }

  // Get all
  getAllPayments(): void {
    this.paymentService.getAllPayments().subscribe(
      res => (this.payments = res),
      err => console.error(err)
    );
  }

  // Get by ID (search)
  searchPayment(): void {
    if (this.searchId !== null) {
      this.paymentService.getPaymentById(this.searchId).subscribe(
        res => (this.selectedPayment = res),
        err => {
          console.error(err);
          alert('❌ Payment not found!');
        }
      );
    }
  }

  clearSearch(): void {
    this.searchId = null;
    this.selectedPayment = null;
  }

  // Delete
  deletePayment(id: number): void {
    if (confirm('Are you sure you want to delete this payment?')) {
      this.paymentService.deletePayment(id).subscribe(
        () => {
          alert('🗑️ Payment deleted!');
          this.getAllPayments();
        },
        err => console.error(err)
      );
    }
  }

  // Patch (verify/update status)
  patchPayment(id: number, status: string): void {
    this.paymentService.patchPayment(id, { status }).subscribe(
      () => {
        alert(`🔄 Payment status updated to ${status}`);
        this.getAllPayments();
      },
      err => console.error(err)
    );
  }

  // Select payment for details
  viewPayment(payment: any): void {
    this.selectedPayment = payment;
  }
}
