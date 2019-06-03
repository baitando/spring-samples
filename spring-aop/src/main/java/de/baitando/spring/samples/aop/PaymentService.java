package de.baitando.spring.samples.aop;

import java.math.BigDecimal;

public interface PaymentService {

    boolean transfer(String ibanSender, String ibanReceiver, BigDecimal amout);
}
