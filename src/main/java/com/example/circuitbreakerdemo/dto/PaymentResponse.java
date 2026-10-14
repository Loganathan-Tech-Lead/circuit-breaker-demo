package com.example.circuitbreakerdemo.dto;

public record PaymentResponse(String orderId, String status, String message) {
}