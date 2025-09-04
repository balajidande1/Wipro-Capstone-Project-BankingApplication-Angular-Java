package com.wipro.balaji.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.balaji.dto.TransactionDto;


@FeignClient(name = "TRANSACTION-SERVICE", path = "/api/transactions")
public interface PaymentFeignClient {
	
	 @GetMapping("/{id}")
	 public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id);

}

