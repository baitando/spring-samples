package de.baitando.spring.samples.profileconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("two")
public class MyServiceTwo implements MyService {

    private final String dummy;

    private MyServiceTwo(@Value("${dummy}") String dummy) {
        this.dummy = dummy;
    }

    @Override
    public String getDummy() {
        return dummy;
    }
}
