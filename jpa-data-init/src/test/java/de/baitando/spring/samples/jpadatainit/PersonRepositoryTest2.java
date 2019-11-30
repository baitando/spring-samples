package de.baitando.spring.samples.jpadatainit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("withoutdatasql")
@RunWith(SpringRunner.class)
public class PersonRepositoryTest2 {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        // Arrange
        testEntityManager.persistAndFlush(new PersonDto("Max", "Mustermann"));

        // Act
        long count = personRepository.count();

        // Assert
        assertThat(count).isEqualTo(2);
    }
}
