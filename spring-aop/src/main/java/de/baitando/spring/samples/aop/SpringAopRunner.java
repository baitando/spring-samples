package de.baitando.spring.samples.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringAopRunner implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(SpringAopRunner.class);
    private PaymentService paymentService;

    @Autowired
    public SpringAopRunner(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) {
        log.info("Received result: {}", paymentService.transfer("IBAN1", "IBAN2", BigDecimal.valueOf(45.99)));
    }
}
