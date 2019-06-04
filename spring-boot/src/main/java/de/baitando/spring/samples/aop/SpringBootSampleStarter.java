package de.baitando.spring.samples.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSampleStarter implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(SpringBootSampleStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleStarter.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info("Hello world!");
    }
}
