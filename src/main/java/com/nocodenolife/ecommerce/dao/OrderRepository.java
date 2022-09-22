package com.nocodenolife.ecommerce.dao;

import com.nocodenolife.ecommerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
    //Spring creates a query based on the method name this creates a query that is
    // SELECT * FROM orders LEFT OUTER JOIN customer On orders.customer_id=customer.id WHERE customer.email=email ORDER BY orders.date_created DESC


}
