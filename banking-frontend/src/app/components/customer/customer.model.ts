export interface Customer{
   
  customerId?: number;   // Primary key (optional when creating new customer)
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  dateOfBirth: string;   // store as ISO string (e.g., "1998-09-03")
  address: string;
  kycStatus: 'PENDING' | 'VERIFIED' | 'REJECTED';  // enum type
  createdAt?: string;    // handled by backend
  updatedAt?: string;    // handled by backend
}
