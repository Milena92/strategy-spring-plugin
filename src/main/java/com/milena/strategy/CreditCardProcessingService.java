package com.milena.strategy;

import org.springframework.stereotype.Component;

@Component
class CreditCardProcessingService implements PaymentProcessingService {

    @Override
    public String processPayment(Integer amount) {
        return "Processing credit card payment: " + amount;
    }

    @Override
    public boolean supports(PaymentMethod delimiter) {
        return delimiter.equals(PaymentMethod.CREDIT_CARD);
    }
}