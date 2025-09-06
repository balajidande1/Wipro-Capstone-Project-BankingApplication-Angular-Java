export enum AccountType {
  SAVINGS = 'SAVINGS',
  CURRENT = 'CURRENT',
  FIXED = 'FIXED',
  RECURRING = 'RECURRING'
}

export interface Account {
  accountId: number;         // Matches the backend primary key
  accountNumber: string;     // Unique account number
  accountType: AccountType;  // Enum for type (SAVINGS, CURRENT, etc.)
  balance: number;           // Balance in INR (or any currency)
  customerId: number;        // Foreign key mapping to Customer.customerId
  createdAt?: string;        // ISO date string (optional)
  updatedAt?: string;        // ISO date string (optional)
}
