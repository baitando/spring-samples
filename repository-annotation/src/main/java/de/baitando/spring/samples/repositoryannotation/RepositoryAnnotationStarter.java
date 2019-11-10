package de.baitando.spring.samples.repositoryannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RepositoryAnnotationStarter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RepositoryAnnotationStarter.class, args);
    }

    private PersonService personService;
    private Logger log = LoggerFactory.getLogger(RepositoryAnnotationStarter.class);

    public RepositoryAnnotationStarter(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting test");
        Person person = personService.savePerson(new Person(Long.valueOf(1), "Max", "Mustermann"));
        log.info("Result after save ok: {}", person);

        personService.deletePerson(Long.valueOf(2));
    }
}
