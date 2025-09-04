package com.wipro.balaji.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AccountAop {
	
    @Before("execution(* com.wipro.balaji.AccountController.createAccount(..))")
    public void logBeforeCreate() {
        log.warn("Logging before creating an account...");
    }

    @After("execution(* com.wipro.balaji.AccountController.createAccount(..))")
    public void logAfterCreate() {
        log.warn("Logging after creating an account...");
    }

    @Before("execution(* com.wipro.balaji.AccountController.getAccountById(..))")
    public void logBeforeGetById() {
        log.warn("Logging before getting account by ID...");
    }

    @After("execution(* com.wipro.balaji.AccountController.getAccountById(..))")
    public void logAfterGetById() {
        log.warn("Logging after getting account by ID...");
    }

    @Before("execution(* com.wipro.balaji.AccountController.getAllAccounts(..))")
    public void logBeforeGetAll() {
        log.warn("Logging before getting all accounts...");
    }

    @After("execution(* com.wipro.balaji.AccountController.getAllAccounts(..))")
    public void logAfterGetAll() {
        log.warn("Logging after getting all accounts...");
    }

    @Before("execution(* com.wipro.balaji.AccountController.patchAccount(..))")
    public void logBeforePatch() {
        log.warn("Logging before patching an account...");
    }

    @After("execution(* com.wipro.balaji.AccountController.patchAccount(..))")
    public void logAfterPatch() {
        log.warn("Logging after patching an account...");
    }

    @Before("execution(* com.wipro.balaji.AccountController.deleteAccount(..))")
    public void logBeforeDelete() {
        log.warn("Logging before deleting an account...");
    }

    @After("execution(* com.wipro.balaji.AccountController.deleteAccount(..))")
    public void logAfterDelete() {
        log.warn("Logging after deleting an account...");
    }

    @Before("execution(* com.wipro.balaji.AccountController.gettingAccountWithCustomerDetails(..))")
    public void logBeforeGetWithCustomer() {
        log.warn("Logging before getting account with customer details...");
    }

    @After("execution(* com.wipro.balaji.AccountController.gettingAccountWithCustomerDetails(..))")
    public void logAfterGetWithCustomer() {
        log.warn("Logging after getting account with customer details...");
    }

}
