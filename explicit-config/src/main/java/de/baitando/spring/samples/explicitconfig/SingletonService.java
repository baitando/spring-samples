package de.baitando.spring.samples.explicitconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonService {

    @Autowired
    private PrototypeService prototypeService;
}
