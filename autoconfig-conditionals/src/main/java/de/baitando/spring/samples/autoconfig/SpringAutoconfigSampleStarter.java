package de.baitando.spring.samples.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringAutoconfigSampleStarter implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(SpringAutoconfigSampleStarter.class);
    private List<DummyService> dummyServices;

    @Autowired
    public SpringAutoconfigSampleStarter(List<DummyService> dummyServices) {
        this.dummyServices = dummyServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAutoconfigSampleStarter.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Hello world!");
        dummyServices.forEach((dummyService -> System.out.println(dummyService.getName())));
    }
}
