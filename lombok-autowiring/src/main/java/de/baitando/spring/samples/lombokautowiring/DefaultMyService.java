package de.baitando.spring.samples.lombokautowiring;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Data
public class DefaultMyService {

    private final MyRepository myRepository;
    private Logger log = LoggerFactory.getLogger(DefaultMyService.class);

    @PostConstruct
    private void init() {

    }
}
