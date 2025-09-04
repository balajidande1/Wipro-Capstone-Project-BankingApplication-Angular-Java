package com.wipro.balaji.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.wipro.balaji.service.NotificationService;
import com.wipro.balaji.dto.NotificationEvent;
import com.wipro.balaji.entity.Notification;
import com.wipro.balaji.enums.NotificationType;


@Service
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "notifications-topic", groupId = "notification-group")
    public void consume(NotificationEvent event) {
        Notification notification = new Notification();
        notification.setCustomerId(event.getCustomerId());
        notification.setTransactionId(event.getTransactionId());
        notification.setMessage(event.getMessage());
        notification.setDelivered(false);
        notification.setType(NotificationType.valueOf(event.getType()));

        notificationService.sendNotification(notification);
    }

}
