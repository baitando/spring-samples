package de.baitando.spring.samples.aop;

import java.util.List;

public interface PaymentService {

    List<Payment> getPayments();

    Payment getPayment(Long id);
}
