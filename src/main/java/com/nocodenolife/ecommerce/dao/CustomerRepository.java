package com.nocodenolife.ecommerce.dao;


import com.nocodenolife.ecommerce.dto.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
