package com.mustafij.ecommercebackend.dao;

import com.mustafij.ecommercebackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
