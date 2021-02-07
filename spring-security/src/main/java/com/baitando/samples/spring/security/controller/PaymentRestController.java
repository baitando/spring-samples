package com.baitando.samples.spring.security.controller;

import com.baitando.samples.spring.security.service.PaymentService;
import com.baitando.samples.spring.security.service.data.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentRestController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }

    @GetMapping("/payments/{id}")
    public Payment getPayments(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

}
