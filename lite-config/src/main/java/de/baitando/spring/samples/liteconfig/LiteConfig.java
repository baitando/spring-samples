package de.baitando.spring.samples.liteconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LiteConfig {

    @Bean
    public DummyService liteDummyServiceMain() {
        System.out.println("**** Lite Config");
        System.out.println(liteDummyServiceDependency());
        System.out.println(liteDummyServiceDependency());
        System.out.println(liteDummyServiceDependency());
        System.out.println(liteDummyServiceDependency());
        System.out.println(liteDummyServiceDependency());
        System.out.println("***");

        return new DummyService();
    }

    @Bean
    public DummyService liteDummyServiceDependency() {
        return new DummyService();
    }
}
