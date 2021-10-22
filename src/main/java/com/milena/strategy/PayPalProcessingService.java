package com.milena.strategy;

import org.springframework.stereotype.Component;

@Component
public class PayPalProcessingService implements PaymentProcessingService {

    @Override
    public String processPayment(Integer amount) {
        return "Processing pay pal payment: " + amount;
    }

    @Override
    public boolean supports(PaymentMethod delimiter) {
        return delimiter.equals(PaymentMethod.PAY_PAL);
    }
}
