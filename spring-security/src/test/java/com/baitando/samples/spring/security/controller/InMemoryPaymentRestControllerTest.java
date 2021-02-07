package com.baitando.samples.spring.security.controller;

import com.baitando.samples.spring.security.service.PaymentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("in-memory")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InMemoryPaymentRestControllerTest extends AbstractPaymentRestControllerTest {

    @MockBean
    private PaymentService paymentService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Override
    PaymentService getPaymentServiceMock() {
        return paymentService;
    }

    @Override
    TestRestTemplate getTestRestTemplate() {
        return restTemplate;
    }
}
