package de.baitando.spring.samples.explicitconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
public class AppConfig {

    @Bean
    public SingletonService singletonService() {
        return new SingletonService();
    }

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public PrototypeService prototypeService() {
        return new PrototypeService();
    }

    @Bean
    // If @Lazy is enabled, the bean is not instantiated when the context starts.
    // It's then done when the bean is requested for the first time
    // @Lazy
    public LocalRefService localRefService() {

        System.out.println("-------------------------");

        System.out.println("Local ref bean #1: " + singletonService());
        System.out.println("Local ref bean #2: " + singletonService());
        System.out.println("Local ref bean #3: " + singletonService());

        return new LocalRefService();
    }
}
