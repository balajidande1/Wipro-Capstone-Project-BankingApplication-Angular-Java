package com.wipro.balaji.utility;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.balaji.dto.AuditEvent;

@Service
public class AuditProducer {
	
	private final KafkaTemplate<String, AuditEvent> kafkaTemplate;

    public AuditProducer(KafkaTemplate<String, AuditEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishAudit(String serviceName, String eventType, String eventData) {
        AuditEvent event = new AuditEvent();
        event.setServiceName(serviceName);
        event.setEventType(eventType);
        event.setEventData(eventData);

        kafkaTemplate.send("audit-events", event);
    }

}
