package de.baitando.spring.samples.restmock.controller;

import java.math.BigDecimal;
import java.util.Currency;

public class ExchangeRequest {

    private BigDecimal amount;
    private Currency originCurrency;
    private Currency targetCurrency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(Currency originCurrency) {
        this.originCurrency = originCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}
