package de.baitando.spring.samples.explicitconfig.subclassing;

public class EnhancedSubclassingFactory extends SubclassingFactory {

    private SubclassingService instance;

    @Override
    public SubclassingService createService() {
        if (instance == null) {
            instance = super.createService();
        }
        return instance;
    }
}
