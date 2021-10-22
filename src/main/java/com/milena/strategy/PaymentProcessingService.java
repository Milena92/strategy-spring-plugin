package com.milena.strategy;

import org.springframework.plugin.core.Plugin;

public interface PaymentProcessingService extends Plugin<PaymentMethod> {
    String processPayment(Integer amount);
}