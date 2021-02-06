package de.baitando.spring.samples.explicitconfig.subclassing;

public class SubclassingTester {

//    public static void main(String[] args) {
////        System.out.println("##### Original Factory");
////        test(getOriginalFactory());
//
//        System.out.println("\n\n##### Proxy Factory");
//        test(getProxyFactory());
//    }

    private static void test(SubclassingFactory factory) {
        System.out.println("***** Factory instance");
        System.out.println(factory);

        System.out.println("\n***** Calling method from outside");
        System.out.println(factory.createService());
        System.out.println(factory.createService());
        System.out.println(factory.createService());

        factory.test();
    }

    private static SubclassingFactory getOriginalFactory() {
        return new SubclassingFactory();
    }

    private static SubclassingFactory getProxyFactory() {
        return new EnhancedSubclassingFactory();
    }
}

