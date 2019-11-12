package de.baitando.spring.samples.componentscan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ComponentScanTest {

    @Autowired
    private DummyService dummyService;

    @Test
    public void test() {
        System.out.println("Bean is: " + dummyService);
    }
}
