package com.wipro.balaji.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.wipro.balaji.enums.KycStatus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private Long customerId; 
	private String firstName; 
	private String lastName; 
	
	private String email; 
	private String phone; 
	private LocalDate dateOfBirth; 
	private String address; 
	 
	private KycStatus kycStatus; // PENDING, VERIFIED, REJECTED 
	private LocalDateTime createdAt; 
	private LocalDateTime updatedAt;

}
