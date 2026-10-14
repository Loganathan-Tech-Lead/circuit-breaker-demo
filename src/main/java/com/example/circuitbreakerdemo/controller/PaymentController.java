package com.example.circuitbreakerdemo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.circuitbreakerdemo.dto.PaymentResponse;

@RestController
public class PaymentController {
    @GetMapping("/payments/{id}")
    public PaymentResponse p(@PathVariable String id, @RequestParam(defaultValue = "SUCCESS") String mode)
            throws Exception {
        if (mode.equals("FAILURE"))
            throw new RuntimeException();
        if (mode.equals("SLOW"))
            Thread.sleep(6000);
        return new PaymentResponse(id, "SUCCESS", "Processed");
    }
}