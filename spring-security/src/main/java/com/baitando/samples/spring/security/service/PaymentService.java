package com.baitando.samples.spring.security.service;

import com.baitando.samples.spring.security.service.data.Payment;

import java.util.List;

/**
 * A payment service allows to access payment transactions.
 */
public interface PaymentService {

    /**
     * Retrieve all payments.
     *
     * @return List of all known payments.
     */
    List<Payment> getPayments();

    /**
     * Retrieve a specific payment.
     *
     * @param id ID of the payment.
     * @return Payment with the given ID.
     */
    Payment getPayment(Long id);
}
