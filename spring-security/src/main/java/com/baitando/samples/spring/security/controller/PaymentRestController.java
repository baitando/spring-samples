package com.baitando.samples.spring.security.controller;

import com.baitando.samples.spring.security.data.Payment;
import com.baitando.samples.spring.security.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Exposes payment related resources.
 */
@RestController
public class PaymentRestController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Exposes all payments.
     *
     * @return A list of all existing payments.
     */
    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }

    /**
     * Expose a specific payment.
     *
     * @param id ID of the desired payment.
     * @return Payment with the given ID.
     */
    @GetMapping("/payments/{id}")
    public Payment getPayments(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

}
