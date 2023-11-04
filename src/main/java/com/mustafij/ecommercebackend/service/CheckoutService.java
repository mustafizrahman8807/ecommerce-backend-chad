package com.mustafij.ecommercebackend.service;

import com.mustafij.ecommercebackend.dto.PaymentInfo;
import com.mustafij.ecommercebackend.dto.Purchase;
import com.mustafij.ecommercebackend.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
