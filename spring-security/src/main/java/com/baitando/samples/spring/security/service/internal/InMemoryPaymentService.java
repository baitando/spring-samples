package com.baitando.samples.spring.security.service.internal;

import com.baitando.samples.spring.security.data.Payment;
import com.baitando.samples.spring.security.service.PaymentService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * An in-memory implementation of the payment service, which holds static dummy data.
 */
@Component
public class InMemoryPaymentService implements PaymentService {

    private final List<Payment> payments;

    public InMemoryPaymentService() {
        payments = new ArrayList<>();
        payments.add(new Payment("DE1234", "ES4321", BigDecimal.valueOf(45.99)));
    }

    @PostAuthorize("@customSecurityChecker.isPermittedPost(returnObject)")
    @Override
    public List<Payment> getPayments() {
        return payments;
    }

    @PreAuthorize("@customSecurityChecker.isPermittedPre(#id)")
    @Override
    public Payment getPayment(Long id) {
        return payments.get(0);
    }
}
