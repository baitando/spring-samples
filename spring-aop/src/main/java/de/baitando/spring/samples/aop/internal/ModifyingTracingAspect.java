package de.baitando.spring.samples.aop.internal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ModifyingTracingAspect {

    private Logger log = LoggerFactory.getLogger(ModifyingTracingAspect.class);

    @Around("within(de.baitando.spring.samples.aop..*) && @annotation(de.baitando.spring.samples.aop.Traced)")
    public boolean around(final ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("Entering method {}", joinPoint.getSignature().getName());
        Boolean result = (Boolean) joinPoint.proceed();
        log.info("Exiting method {}", joinPoint.getSignature().getName());
        return !result;
    }

}
