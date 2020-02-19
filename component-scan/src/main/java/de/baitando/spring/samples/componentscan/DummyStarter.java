package de.baitando.spring.samples.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class DummyStarter implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DummyStarter.class);
    }

    @Autowired
    private DummyService dummyService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dummyService);
    }
}
