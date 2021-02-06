package de.baitando.spring.samples.liteconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FullConfig {

    @Bean
    public DummyService fullDummyServiceMain() {
        System.out.println("**** Full Config");
        System.out.println(fullDummyServiceDependency());
        System.out.println(fullDummyServiceDependency());
        System.out.println(fullDummyServiceDependency());
        System.out.println(fullDummyServiceDependency());
        System.out.println(fullDummyServiceDependency());
        System.out.println("***");

        return new DummyService();
    }

    @Bean
    public DummyService fullDummyServiceDependency() {
        return new DummyService();
    }
}
