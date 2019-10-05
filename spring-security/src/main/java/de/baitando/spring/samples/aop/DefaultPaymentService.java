package de.baitando.spring.samples.aop;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPaymentService implements PaymentService {

    private List<Payment> payments;

    public DefaultPaymentService() {
        payments = new ArrayList<>();
        payments.add(new Payment("init1", "recv1", BigDecimal.valueOf(45.99)));
    }

    @PostAuthorize("@mySecurityChecker.isPermittedPost(returnObject)")
    @Override
    public List<Payment> getPayments() {
        return payments;
    }

    @PreAuthorize("@mySecurityChecker.isPermittedPre(#id)")
    @Override
    public Payment getPayment(Long id) {
        return payments.get(0);
    }
}
