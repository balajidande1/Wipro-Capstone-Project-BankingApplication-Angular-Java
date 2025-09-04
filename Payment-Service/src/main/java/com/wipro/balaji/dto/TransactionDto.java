package com.wipro.balaji.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
	
	private Long transactionId;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private String transactionType;   // or Enum, but must match EXTERNAL, INTERNAL
    private BigDecimal amount;
    private String currency;
    private String status;           // INITIATED, COMPLETED, FAILED
    private String failureReason;
    private LocalDateTime createdAt;

}
