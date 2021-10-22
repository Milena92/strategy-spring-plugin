package com.milena.strategy;

import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PluginRegistry<PaymentProcessingService, PaymentMethod> pluginRegistry;

    public PaymentController(PluginRegistry<PaymentProcessingService, PaymentMethod> pluginRegistry) {
        this.pluginRegistry = pluginRegistry;
    }

    @PostMapping
    public ResponseEntity<String> pay(@RequestBody PaymentRequest paymentRequest) {
        PaymentProcessingService paymentProcessingService = pluginRegistry.getPluginFor(paymentRequest.getPaymentMethod())
                .orElseThrow(() -> new RuntimeException("Payment method not supported"));

        return ResponseEntity.ok(paymentProcessingService.processPayment(paymentRequest.getAmount()));
    }
}
