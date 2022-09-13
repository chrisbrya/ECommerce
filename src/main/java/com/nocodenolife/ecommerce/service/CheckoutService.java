package com.nocodenolife.ecommerce.service;

import com.nocodenolife.ecommerce.dto.Purchase;
import com.nocodenolife.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
