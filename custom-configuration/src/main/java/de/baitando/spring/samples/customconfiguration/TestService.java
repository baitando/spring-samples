package de.baitando.spring.samples.customconfiguration;

import org.springframework.stereotype.Service;

@Service
public class TestService {


    private final TestProperties config;

    public TestService(TestProperties config) {
        this.config = config;
    }
}
