import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../../../services/transaction.service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-transaction-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {
    transactionForm!: FormGroup;
  transactions: any[] = [];
  selectedTransaction: any = null;
  searchId!: number;

  constructor(
    private fb: FormBuilder,
    private transactionService: TransactionService
  ) {}

  ngOnInit(): void {
    this.transactionForm = this.fb.group({
      transactionId: ['', Validators.required],
      accountId: ['', Validators.required],
      amount: ['', [Validators.required, Validators.min(1)]],
      type: ['', Validators.required],   // CREDIT / DEBIT
      status: ['PENDING', Validators.required]
    });

    this.getAllTransactions();
  }

  onSubmit(): void {
    if (this.transactionForm.valid) {
      this.transactionService.createTransaction(this.transactionForm.value)
        .subscribe({
          next: (res) => {
            alert('Transaction added successfully!');
            this.transactionForm.reset();
            this.getAllTransactions();
          },
          error: (err) => console.error(err)
        });
    }
  }

  getAllTransactions(): void {
    this.transactionService.getAllTransactions().subscribe({
      next: (data) => this.transactions = data,
      error: (err) => console.error(err)
    });
  }

  searchTransaction(): void {
    if (this.searchId) {
      this.transactionService.getTransactionById(this.searchId).subscribe({
        next: (data) => this.selectedTransaction = data,
        error: () => {
          alert('Transaction not found');
          this.selectedTransaction = null;
        }
      });
    }
  }

  clearSearch(): void {
    this.searchId = 0;
    this.selectedTransaction = null;
  }

  viewTransaction(transaction: any): void {
    this.selectedTransaction = transaction;
  }

  patchTransaction(id: number, status: string): void {
    this.transactionService.patchTransaction(id, { status }).subscribe({
      next: () => {
        alert(`Transaction status updated to ${status}`);
        this.getAllTransactions();
      },
      error: (err) => console.error(err)
    });
  }
}
