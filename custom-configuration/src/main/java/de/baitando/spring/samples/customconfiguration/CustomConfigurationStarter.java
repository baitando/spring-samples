package de.baitando.spring.samples.customconfiguration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomConfigurationStarter implements CommandLineRunner {

    private TestProperties testProperties;

    public CustomConfigurationStarter(TestProperties testProperties) {
        this.testProperties = testProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomConfigurationStarter.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Properties: " + testProperties);
    }
}
