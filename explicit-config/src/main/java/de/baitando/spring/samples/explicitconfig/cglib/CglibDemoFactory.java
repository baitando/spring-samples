package de.baitando.spring.samples.explicitconfig.cglib;

public class CglibDemoFactory {

    public void test() {
        System.out.println("\n***** Calling method from inside");
        System.out.println(createService());
        System.out.println(createService());
        System.out.println(createService());
    }

    public CglibDemoService createService() {
        return new CglibDemoService();
    }
}
