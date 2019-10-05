package de.baitando.spring.samples.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MySecurityChecker {

    private Logger logger = LoggerFactory.getLogger(MySecurityChecker.class);

    public boolean isPermittedPost(List<Payment> payments) {
        logger.info("Checking isPermittedPost() for {}", payments);
        return true;
    }

    public boolean isPermittedPre(Long id) {
        logger.info("Checking isPermittedPre() for {}", id);
        return false;
    }
}
