package com.wipro.balaji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.balaji.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
