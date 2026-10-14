package com.example.circuitbreakerdemo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import com.example.circuitbreakerdemo.client.PaymentClient;
import com.example.circuitbreakerdemo.dto.PaymentResponse;

@Service
public class OrderService {
    private final PaymentClient c;

    public OrderService(PaymentClient c) {
        this.c = c;
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallback")
    public PaymentResponse process(String id) {
        return c.pay(id);
    }

    public PaymentResponse fallback(String id, Exception e) {
        return new PaymentResponse(id, "FALLBACK", "Payment unavailable");
    }
}