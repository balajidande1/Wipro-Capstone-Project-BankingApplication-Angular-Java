package com.wipro.balaji.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.wipro.balaji.enums.TransactionStatus;
import com.wipro.balaji.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    
    @NotNull
    private Long sourceAccountId;
    @NotNull
    private Long destinationAccountId;
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType; // INTERNAL, EXTERNAL

    private BigDecimal amount;
    private String currency;
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TransactionStatus status; // INITIATED, COMPLETED, FAILED

    private String failureReason;

    private LocalDateTime createdAt = LocalDateTime.now();

}
