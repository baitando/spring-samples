package de.baitando.spring.samples.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerRest {

    private Counter requestCounter;

    public DummyControllerRest(MeterRegistry meterRegistry) {
        requestCounter = Counter.builder("dummy.counter").register(meterRegistry);
    }

    @GetMapping("/dummy")
    public String getDummy()
    {
        requestCounter.increment();
        return "Requests received: " + requestCounter.count();
    }
}
