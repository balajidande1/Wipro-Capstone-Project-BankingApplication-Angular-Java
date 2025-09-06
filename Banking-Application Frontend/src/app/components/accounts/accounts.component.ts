import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AccountService } from '../services/account.service';
import { Account, AccountType } from './account.model';


@Component({
  selector: 'app-account-list',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountComponent implements OnInit{

   accounts: Account[] = [];
  selectedAccount: Account | null = null;
  searchNumber: string = "";
  newAccount: Account = {
    accountId: 0,
    accountNumber: "",
    accountType: AccountType.SAVINGS,
    balance: 0,
    customerId: 0,
  };
  accountForm!: FormGroup;

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.loadAccounts();
    this.accountForm = new FormGroup({
      accountId: new FormControl(""),
      accountNumber: new FormControl("", Validators.required),
      accountType: new FormControl("", Validators.required),
      balance: new FormControl(0, Validators.required),
      customerId: new FormControl(0, Validators.required),
    });
  }

  // ✅ Load all accounts
  loadAccounts(): void {
    this.accountService.getAllAccounts().subscribe(
      (accounts: Account[]) => {
        this.accounts = accounts;
      },
      (error) => console.error("Error while loading accounts: ", error)
    );
  }

  // ✅ View account details
  viewAccount(account: Account): void {
    this.selectedAccount = account;
  }

  // ✅ Save (create/update) account
  saveAccount(): void {
    if (this.newAccount.accountId === 0) {
      this.accountService.addAccount(this.newAccount).subscribe((account) => {
        this.accounts.push(account);
        this.clearForm();
      });
    } else {
      this.accountService
        .updateAccount(this.newAccount.accountId, this.newAccount)
        .subscribe((updatedAccount) => {
          const index = this.accounts.findIndex(
            (a) => a.accountId === updatedAccount.accountId
          );
          if (index !== -1) {
            this.accounts[index] = updatedAccount;
          }
          this.clearForm();
        });
    }
  }

  // ✅ Edit account
  editAccount(account: Account): void {
    this.newAccount = { ...account };
  }

  // ✅ Delete account
  deleteAccount(id: number): void {
    this.accountService.deleteAccount(id).subscribe(() => {
      this.accounts = this.accounts.filter((account) => account.accountId !== id);
    });
  }

  // ✅ Search by account number
  searchAccount(): void {
    if (this.searchNumber) {
      this.accounts = this.accounts.filter((account) =>
        account.accountNumber.includes(this.searchNumber)
      );
    }
  }

  // ✅ Reset form
  clearForm(): void {
    this.newAccount = {
      accountId: 0,
      accountNumber: "",
      accountType: AccountType.SAVINGS,
      balance: 0,
      customerId: 0,
    };
  }

  // ✅ Clear search filter
  clearSearch(): void {
    this.searchNumber = "";
    this.loadAccounts();
  }

}
