package com.wipro.balaji.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class CustomerAop {
	
    @Before("execution(* com.wipro.balaji.CustomerController.createCustomer(..))")
    public void logBeforeCreate() {
        log.warn("Logging before creating a customer...");
    }

    @After("execution(* com.wipro.balaji.CustomerController.createCustomer(..))")
    public void logAfterCreate() {
        log.warn("Logging after creating a customer...");
    }

    @Before("execution(* com.wipro.balaji.CustomerController.getCustomerById(..))")
    public void logBeforeGetById() {
        log.warn("Logging before getting customer by ID...");
    }

    @After("execution(* com.wipro.balaji.CustomerController.getCustomerById(..))")
    public void logAfterGetById() {
        log.warn("Logging after getting customer by ID...");
    }

    @Before("execution(* com.wipro.balaji.CustomerController.getAllCustomers(..))")
    public void logBeforeGetAll() {
        log.warn("Logging before getting all customers...");
    }

    @After("execution(* com.wipro.balaji.CustomerController.getAllCustomers(..))")
    public void logAfterGetAll() {
        log.warn("Logging after getting all customers...");
    }

    @Before("execution(* com.wipro.balaji.CustomerController.patchCustomer(..))")
    public void logBeforePatch() {
        log.warn("Logging before patching a customer...");
    }

    @After("execution(* com.wipro.balaji.CustomerController.patchCustomer(..))")
    public void logAfterPatch() {
        log.warn("Logging after patching a customer...");
    }

    @Before("execution(* com.wipro.balaji.CustomerController.deleteCustomer(..))")
    public void logBeforeDelete() {
        log.warn("Logging before deleting a customer...");
    }

    @After("execution(* com.wipro.balaji.CustomerController.deleteCustomer(..))")
    public void logAfterDelete() {
        log.warn("Logging after deleting a customer...");
    }

}
