package de.baitando.spring.samples.liteconfig;

import org.springframework.context.annotation.Bean;

public class LiteConfigPlain {

    @Bean
    public DummyService liteDummyServiceMainPlain() {
        System.out.println("**** Lite Config Plain");
        System.out.println(liteDummyServiceDependencyPlain());
        System.out.println(liteDummyServiceDependencyPlain());
        System.out.println(liteDummyServiceDependencyPlain());
        System.out.println(liteDummyServiceDependencyPlain());
        System.out.println(liteDummyServiceDependencyPlain());
        System.out.println("***");

        return new DummyService();
    }

    @Bean
    public DummyService liteDummyServiceDependencyPlain() {
        return new DummyService();
    }
}
