package de.baitando.spring.samples.springdatajpa;

import de.baitando.spring.samples.springdatajpa.repository.Account;
import de.baitando.spring.samples.springdatajpa.repository.AccountRepository;
import de.baitando.spring.samples.springdatajpa.repository.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Currency;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findByIban_withExistingAccount_returnsAccount() {

        // Arrange

        // Act
        Optional<Account> account = accountRepository.findAccountByIban("abcdefg");

        // Assert
        assertTrue(account.isPresent());
        assertThat(account.get().getIban()).isEqualTo("abcdefg");
        assertThat(account.get().getBalance()).isEqualTo(new Money(34.99, Currency.getInstance("EUR")));
    }
}
