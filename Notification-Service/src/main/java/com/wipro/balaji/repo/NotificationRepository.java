package com.wipro.balaji.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.balaji.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<Notification> findByCustomerId(Long customerId);

	List<Notification> findByTransactionId(Long transactionId);

	List<Notification> findByDelivered(boolean delivered);

}
