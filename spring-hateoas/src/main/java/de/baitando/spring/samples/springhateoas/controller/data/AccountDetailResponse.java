package de.baitando.spring.samples.springhateoas.controller.data;

import org.springframework.hateoas.RepresentationModel;

public class AccountDetailResponse extends RepresentationModel<AccountDetailResponse> {

    private Long id;
    private String iban;

    public AccountDetailResponse(Long id, String iban) {
        this.id = id;
        this.iban = iban;
    }

    public Long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }
}
