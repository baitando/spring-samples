package de.baitando.spring.samples.repositoryannotation;

import org.springframework.stereotype.Service;

public interface PersonService {

    Person savePerson(Person person);

    void deletePerson(Long id);
}
