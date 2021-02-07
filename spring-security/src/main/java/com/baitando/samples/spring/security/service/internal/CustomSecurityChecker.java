package com.baitando.samples.spring.security.service.internal;

import com.baitando.samples.spring.security.data.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A custom component which can be used with {@code @PreAuthorize} and {@code @PostAuthorize} to ensure specific
 * security checks. In this example we always allow and log a message which allows us to detect, if the check methods
 * were called or not.
 */
@Component
public class CustomSecurityChecker {

    private final Logger logger = LoggerFactory.getLogger(CustomSecurityChecker.class);

    /**
     * Check whether it is permitted to return the given list of payments. We always return {@code true} and log
     * a message.
     *
     * @param payments List of payments to check.
     * @return Always {@code true}.
     */
    public boolean isPermittedPost(List<Payment> payments) {
        logger.info("Checking isPermittedPost() for {}", payments);
        return true;
    }

    /**
     * Check whether it is permitted to access the payment with the given ID. We always return {@code true} and log
     * a message.
     *
     * @param id ID of the payment to check.
     * @return Always {@code true}.
     */
    public boolean isPermittedPre(Long id) {
        logger.info("Checking isPermittedPre() for {}", id);
        return true;
    }
}
