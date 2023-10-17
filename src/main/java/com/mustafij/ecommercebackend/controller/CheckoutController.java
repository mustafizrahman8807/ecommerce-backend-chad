package com.mustafij.ecommercebackend.controller;

import com.mustafij.ecommercebackend.dto.Purchase;
import com.mustafij.ecommercebackend.dto.PurchaseResponse;
import com.mustafij.ecommercebackend.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {

        this.checkoutService = checkoutService;

    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
