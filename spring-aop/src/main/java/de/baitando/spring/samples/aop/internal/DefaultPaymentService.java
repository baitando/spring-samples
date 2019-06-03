package de.baitando.spring.samples.aop.internal;

import de.baitando.spring.samples.aop.PaymentService;
import de.baitando.spring.samples.aop.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DefaultPaymentService implements PaymentService {

    private Logger log = LoggerFactory.getLogger(DefaultPaymentService.class);

    @Traced
    @Override
    public boolean transfer(String ibanSender, String ibanReceiver, BigDecimal amount) {
        log.info("Transfering {} from {} to {}", amount, ibanSender, ibanReceiver);
        boolean result = true;
        log.info("Returning result: {}", result);

        return result;
    }
}
