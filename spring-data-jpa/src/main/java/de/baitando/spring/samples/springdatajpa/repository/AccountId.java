package de.baitando.spring.samples.springdatajpa.repository;

import javax.persistence.Embeddable;

@Embeddable
public class AccountId {

    private String part1;
    private String part2;
}
