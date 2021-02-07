package com.baitando.samples.spring.security.controller;

import com.baitando.samples.spring.security.service.PaymentService;
import com.baitando.samples.spring.security.service.data.Payment;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public abstract class AbstractPaymentRestControllerTest {

    abstract PaymentService getPaymentServiceMock();

    abstract TestRestTemplate getTestRestTemplate();

    @Test
    public void validUser_getPaymentList_returnsList() {
        when(getPaymentServiceMock().getPayments()).thenReturn(
                singletonList(new Payment("DE789", "ES987", BigDecimal.valueOf(12.01))));

        ResponseEntity<Payment[]> payments = getTestRestTemplate()
                .withBasicAuth("max", "maxpwd")
                .getForEntity("/payments", Payment[].class);

        assertThat(payments.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(payments.getBody()).hasSize(1);
    }

    @Test
    public void anonymous_getPaymentList_unautorized() {
        when(getPaymentServiceMock().getPayments()).thenReturn(
                singletonList(new Payment("DE789", "ES987", BigDecimal.valueOf(12.01))));

        ResponseEntity<Void> payments = getTestRestTemplate().getForEntity("/payments", Void.class);

        assertThat(payments.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void wrongRole_getPaymentList_forbidden() {
        when(getPaymentServiceMock().getPayments()).thenReturn(
                singletonList(new Payment("DE789", "ES987", BigDecimal.valueOf(12.01))));

        ResponseEntity<Void> payments = getTestRestTemplate()
                .withBasicAuth("melanie", "melaniepwd")
                .getForEntity("/payments", Void.class);

        assertThat(payments.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }
}
