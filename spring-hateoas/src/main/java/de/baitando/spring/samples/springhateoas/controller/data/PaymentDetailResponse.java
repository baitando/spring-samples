package de.baitando.spring.samples.springhateoas.controller.data;

import org.springframework.hateoas.RepresentationModel;

public class PaymentDetailResponse extends RepresentationModel<PaymentDetailResponse> {
    private Long id;
    private AccountDetailResponse initiator;
    private AccountDetailResponse counterparty;
    private Double amount;

    public PaymentDetailResponse(Long id, AccountDetailResponse initiator, AccountDetailResponse counterparty, Double amount) {
        this.id = id;
        this.initiator = initiator;
        this.counterparty = counterparty;
        this.amount = amount;
    }

    public AccountDetailResponse getInitiator() {
        return initiator;
    }

    public AccountDetailResponse getCounterparty() {
        return counterparty;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }
}
