package com.wipro.balaji.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.balaji.dto.AccountDto;

@FeignClient(name = "ACCOUNT-SERVICE", path = "/api/account")
public interface TransactionFeignClient {
	
	@GetMapping("/{id}")
	public AccountDto getAccountById(@PathVariable Long id);

}
