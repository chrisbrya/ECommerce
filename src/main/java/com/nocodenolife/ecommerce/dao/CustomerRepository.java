package com.nocodenolife.ecommerce.dao;


import com.nocodenolife.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);
    // creates query automatically by spring
    // select * from customer c where c.email = theEmail
}
