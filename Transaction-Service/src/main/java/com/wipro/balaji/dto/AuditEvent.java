package com.wipro.balaji.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditEvent {
	
    private String serviceName;
    private String eventType;
    private String eventData;

}
