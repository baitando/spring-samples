package de.baitando.spring.samples.jpadatainit;

import org.assertj.core.util.IterableUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * There is a {@code data.sql} used without a {@code schema.sql} file. Hibernate creates the schema. One data entry
 * is created with {@code data.sql} and one with `TestEntityManager`. Because of the absence of a {@code schema.sql}
 * file, the {@code data.sql} script now runs after Hibernate created the schema. There are two data entries in
 * the database.
 */
@DataJpaTest
@ActiveProfiles("scenario5")
@RunWith(SpringRunner.class)
public class PersonRepositoryTestScenario5 {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Logger log = LoggerFactory.getLogger(PersonRepositoryTestScenario5.class);

    @Test
    public void test() {
        // Arrange
        testEntityManager.persistAndFlush(new PersonDto("Marta", "Mustermann"));

        // Act
        Iterable<PersonDto> result = personRepository.findAll();
        log.info("The data entries are the following ones: {}", result);

        // Assert
        assertThat(IterableUtil.sizeOf(result)).isEqualTo(2);
    }
}
