package com.wipro.balaji.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class TransactionAop {
	
    @Before("execution(* com.wipro.balaji.TransactionController.createTransaction(..))")
    public void logBeforeCreate() {
        log.warn("Logging before creating a transaction...");
    }

    @After("execution(* com.wipro.balaji.TransactionController.createTransaction(..))")
    public void logAfterCreate() {
        log.warn("Logging after creating a transaction...");
    }

    @Before("execution(* com.wipro.balaji.TransactionController.getTransactionById(..))")
    public void logBeforeGetById() {
        log.warn("Logging before getting transaction by ID...");
    }

    @After("execution(* com.wipro.balaji.TransactionController.getTransactionById(..))")
    public void logAfterGetById() {
        log.warn("Logging after getting transaction by ID...");
    }

    @Before("execution(* com.wipro.balaji.TransactionController.getAllTransactions(..))")
    public void logBeforeGetAll() {
        log.warn("Logging before getting all transactions...");
    }

    @After("execution(* com.wipro.balaji.TransactionController.getAllTransactions(..))")
    public void logAfterGetAll() {
        log.warn("Logging after getting all transactions...");
    }

    @Before("execution(* com.wipro.balaji.TransactionController.updateTransactionStatus(..))")
    public void logBeforeUpdateStatus() {
        log.warn("Logging before updating transaction status...");
    }

    @After("execution(* com.wipro.balaji.TransactionController.updateTransactionStatus(..))")
    public void logAfterUpdateStatus() {
        log.warn("Logging after updating transaction status...");
    }

    @Before("execution(* com.wipro.balaji.TransactionController.getTransactionWithAccountDetails(..))")
    public void logBeforeGetWithAccount() {
        log.warn("Logging before getting transaction with account details...");
    }

    @After("execution(* com.wipro.balaji.TransactionController.getTransactionWithAccountDetails(..))")
    public void logAfterGetWithAccount() {
        log.warn("Logging after getting transaction with account details...");
    }

}
