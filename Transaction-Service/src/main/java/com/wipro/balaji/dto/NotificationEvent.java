package com.wipro.balaji.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent {
	
    private Long customerId;
    private Long transactionId;
    private String message;
    private String type;   // EMAIL, SMS, PUSH

}
