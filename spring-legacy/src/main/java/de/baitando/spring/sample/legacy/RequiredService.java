package de.baitando.spring.sample.legacy;

import org.springframework.stereotype.Component;

@Component
public class RequiredService {

    public String getGreeting() {
        return "Hello World!";
    }
}
