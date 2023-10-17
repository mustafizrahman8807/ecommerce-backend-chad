package com.mustafij.ecommercebackend.service;

import com.mustafij.ecommercebackend.dto.Purchase;
import com.mustafij.ecommercebackend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
