package de.baitando.spring.samples.explicitconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExplicitConfigStarter {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("-------------------------");

        System.out.println("Singleton Bean #1: " + context.getBean(SingletonService.class));
        System.out.println("Singleton Bean #2: " + context.getBean(SingletonService.class));
        System.out.println("Singleton Bean #3: " + context.getBean(SingletonService.class));

        System.out.println("-------------------------");

        System.out.println("Prototype Bean #1: " + context.getBean(PrototypeService.class));
        System.out.println("Prototype Bean #2: " + context.getBean(PrototypeService.class));
        System.out.println("Prototype Bean #3: " + context.getBean(PrototypeService.class));

        System.out.println("-------------------------");

        // Activate this for the demo of @Lazy in the configuration class
        context.getBean(LocalRefService.class);

        // Add breakpoint here to check whether a proxy is returned or not (depdends
        // on proxyMode of @Scope
        SingletonService s = context.getBean(SingletonService.class);

    }

}
