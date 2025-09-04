package com.wipro.balaji.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.balaji.entity.Notification;
import com.wipro.balaji.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {
	
	private final NotificationService notificationService;
	
    // 1. Send new notification
    @PostMapping("/createNotification")
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.sendNotification(notification));
    }

    // 2. Get all notifications
    @GetMapping("/getAllNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    // 3. Get notifications by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Notification>> getByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(notificationService.getNotificationsByCustomer(customerId));
    }

    // 4. Get notifications by transaction
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<List<Notification>> getByTransaction(@PathVariable Long transactionId) {
        return ResponseEntity.ok(notificationService.getNotificationsByTransaction(transactionId));
    }

    // 5. Get notifications by delivery status
    @GetMapping("/delivered/{status}")
    public ResponseEntity<List<Notification>> getByDeliveryStatus(@PathVariable boolean delivered) {
        return ResponseEntity.ok(notificationService.getNotificationsByDeliveryStatus(delivered));
    }

    // 6. Mark notification as delivered
    @PatchMapping("/{id}/deliver")
    public ResponseEntity<Notification> markAsDelivered(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.markAsDelivered(id));
    }

}
