package com.wipro.balaji.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wipro.balaji.enums.AccountStatus;
import com.wipro.balaji.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountWithCustomerDto {
	
    private Long accountId;

    private String accountNumber;

    
    private AccountType accountType;

    private AccountStatus accountStatus;

    private LocalDate openingDate;

    private BigDecimal availableBalance;
    private CustomerDto customer;

}
