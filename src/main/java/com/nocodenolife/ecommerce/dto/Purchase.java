package com.nocodenolife.ecommerce.dto;

import com.nocodenolife.ecommerce.dto.entity.Address;
import com.nocodenolife.ecommerce.dto.entity.Customer;
import com.nocodenolife.ecommerce.dto.entity.Order;
import com.nocodenolife.ecommerce.dto.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
