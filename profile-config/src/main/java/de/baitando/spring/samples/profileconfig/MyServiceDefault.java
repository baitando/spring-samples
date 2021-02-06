package de.baitando.spring.samples.profileconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * This is the default service. It makes use of the <code>default</code> profile and is therefore active, if no
 * profile is set explicitly.
 */
@Service
@Profile("default")
public class MyServiceDefault implements MyService {

    private final String dummy;

    private MyServiceDefault(@Value("${dummy}") String dummy) {
        this.dummy = dummy;
    }

    @Override
    public String getDummy() {
        return dummy;
    }
}
