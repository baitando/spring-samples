package de.baitando.spring.samples.annotationinheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationInheritanceStarter {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("de.baitando.spring.samples.annotationinheritance");

        System.out.println("Parent: " + applicationContext.getBean(ParentPaymentService.class));
        System.out.println("Child: " + applicationContext.getBean(ChildPaymentService.class));

    }
}
