package de.baitando.spring.sample.legacy;

public class DummyDataSet {

    private RequiredService requiredService;

    public DummyDataSet() {
//        StaticApplicationContext.
    }

    public String getText() {
        return requiredService.getGreeting();
    }
}
