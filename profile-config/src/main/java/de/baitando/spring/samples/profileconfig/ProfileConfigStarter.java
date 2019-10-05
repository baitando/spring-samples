package de.baitando.spring.samples.profileconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileConfigStarter implements CommandLineRunner {

    private MyService service;
    private Logger log = LoggerFactory.getLogger(ProfileConfigStarter.class);

    public ProfileConfigStarter(MyService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProfileConfigStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("MyService: {}", service);
        log.info("Dummy: {}", service.getDummy());
    }
}
