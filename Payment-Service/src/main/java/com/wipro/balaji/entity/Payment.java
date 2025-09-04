package com.wipro.balaji.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.wipro.balaji.enums.PaymentMethod;
import com.wipro.balaji.enums.PaymentStatus;

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
@Table(name = "payments")
@Entity
public class Payment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    
    @NotNull
    private Long transactionId; // Link to Transaction Service

    @Enumerated(EnumType.STRING)
    private PaymentMethod method; // UPI, CARD, NETBANKING

    private BigDecimal amount;
    private String currency;
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // PENDING, SUCCESS, FAILED

    private String externalReferenceId; // ID from external provider
    private String failureReason;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();


}
