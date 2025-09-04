package com.wipro.balaji.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.balaji.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
