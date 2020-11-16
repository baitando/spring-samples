package de.baitando.spring.samples.explicitconfig.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class CglibTester {

    public static void main(String[] args) {
        System.out.println("##### Original Factory");
        test(getOriginalFactory());

        System.out.println("\n\n##### Proxy Factory");
        test(getProxyFactory());
    }

    private static void test(CglibDemoFactory factory) {
        System.out.println("***** Factory instance");
        System.out.println(factory);

        System.out.println("\n***** Calling method from outside");
        System.out.println(factory.createService());
        System.out.println(factory.createService());
        System.out.println(factory.createService());

        factory.test();
    }

    private static CglibDemoFactory getOriginalFactory() {
        return new CglibDemoFactory();
    }

    private static CglibDemoFactory getProxyFactory() {
        return (CglibDemoFactory) Enhancer.create(CglibDemoFactory.class, new CglibMethodInterceptor());
    }
}

