package com.wipro.balaji.dto;

import java.math.BigDecimal;

import com.wipro.balaji.enums.TransactionStatus;
import com.wipro.balaji.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionWithAccountDto {
	
    private Long transactionId;

    private Long sourceAccountId;
    private Long destinationAccountId;

    private TransactionType transactionType; // INTERNAL, EXTERNAL

    private BigDecimal amount;
    private String currency;

    private TransactionStatus status; // INITIATED, COMPLETED, FAILED
    
    private AccountDto account;
}
