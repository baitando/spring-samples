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
 * There is a {@code data.sql} and a `schema.sql` file used, but the JPA provider also generates the schema and overwrites the schema created by `schema.sql`.
 * One data entry is created with {@code data.sql} and one with {@link TestEntityManager}.
 * Due to the JPA provider overwriting the initial schema, the data created by {@code data.sql} is lost.
 * There is only one data entry in the database.
 */
@DataJpaTest
@ActiveProfiles("scenario4")
@RunWith(SpringRunner.class)
public class PersonRepositoryTestScenario4 {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Logger log = LoggerFactory.getLogger(PersonRepositoryTestScenario4.class);

    @Test
    public void test() {
        // Arrange
        testEntityManager.persistAndFlush(new PersonDto("Marta", "Mustermann"));

        // Act
        Iterable<PersonDto> result = personRepository.findAll();
        log.info("The data entries are the following ones: {}", result);

        // Assert
        assertThat(IterableUtil.sizeOf(result)).isEqualTo(1);
    }
}
