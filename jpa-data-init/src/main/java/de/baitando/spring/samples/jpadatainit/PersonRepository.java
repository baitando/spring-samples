package de.baitando.spring.samples.jpadatainit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonDto, Long> {
}
