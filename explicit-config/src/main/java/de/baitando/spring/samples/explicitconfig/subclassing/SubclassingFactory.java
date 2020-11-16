package de.baitando.spring.samples.explicitconfig.subclassing;

public class SubclassingFactory {

    public void test() {
        System.out.println("\n***** Calling method from inside");
        System.out.println(createService());
        System.out.println(createService());
        System.out.println(createService());
    }

    public SubclassingService createService() {
        return new SubclassingService();
    }
}
