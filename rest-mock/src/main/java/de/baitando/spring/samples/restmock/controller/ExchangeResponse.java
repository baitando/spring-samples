package de.baitando.spring.samples.restmock.controller;

import java.math.BigDecimal;
import java.util.Currency;

public class ExchangeResponse {

    private BigDecimal originAmount;
    private Currency originCurrency;
    private BigDecimal targetAmount;
    private Currency targetCurrency;

    public ExchangeResponse(BigDecimal originAmount, Currency originCurrency, BigDecimal targetAmount, Currency targetCurrency) {
        this.originAmount = originAmount;
        this.originCurrency = originCurrency;
        this.targetAmount = targetAmount;
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(BigDecimal originAmount) {
        this.originAmount = originAmount;
    }

    public Currency getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(Currency originCurrency) {
        this.originCurrency = originCurrency;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}
