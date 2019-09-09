package de.baitando.spring.samples.packagescan;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class PackageScanTest {

    @Autowired
    private TestService testService;

    @Test
    public void testContext() {
        System.out.println("Test service: " + testService);
        Assertions.assertThat(testService).isNotNull();
    }

    @Configuration
    @ComponentScan
    static class TestConfig {

    }
}
