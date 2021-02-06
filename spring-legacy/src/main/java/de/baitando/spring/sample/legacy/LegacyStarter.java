package de.baitando.spring.sample.legacy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LegacyStarter implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(LegacyStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(LegacyStarter.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("I'm there");

        DummyDataSet dummyDataSet = new DummyDataSet();
        logger.info("This is the text: {}", dummyDataSet);
    }
}
