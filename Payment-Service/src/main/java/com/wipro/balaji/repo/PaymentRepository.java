package com.wipro.balaji.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.balaji.entity.Payment;
import com.wipro.balaji.enums.PaymentStatus;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByStatus(PaymentStatus status);

}
