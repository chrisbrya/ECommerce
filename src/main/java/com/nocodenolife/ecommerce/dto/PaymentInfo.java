package com.nocodenolife.ecommerce.dto;

import lombok.Data;

@Data
public class PaymentInfo {

    // in stripe api make use of lowest denomination which is cents in US dollar have to convert the amount in cents
    //to convert just multiply by 100
    private int amount;
    private String currency;
    private String receiptEmail;
}
