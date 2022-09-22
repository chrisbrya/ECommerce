package com.nocodenolife.ecommerce.service;

import com.nocodenolife.ecommerce.dto.PaymentInfo;
import com.nocodenolife.ecommerce.dto.Purchase;
import com.nocodenolife.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
