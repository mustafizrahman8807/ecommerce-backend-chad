package com.mustafij.ecommercebackend.dto;

import com.mustafij.ecommercebackend.entity.Address;
import com.mustafij.ecommercebackend.entity.Customer;
import com.mustafij.ecommercebackend.entity.Order;
import com.mustafij.ecommercebackend.entity.OrderItem;
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
