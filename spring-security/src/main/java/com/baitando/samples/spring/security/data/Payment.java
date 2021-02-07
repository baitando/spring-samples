package com.baitando.samples.spring.security.data;

import java.math.BigDecimal;

/**
 * Represents a payment, i.e. a transaction which transfers money from one account to another.
 */
public class Payment {
    private final String ibanInitiator;
    private final String ibanReceiver;
    private final BigDecimal amount;

    public Payment(String ibanInitiator, String ibanReceiver, BigDecimal amount) {
        this.ibanInitiator = ibanInitiator;
        this.ibanReceiver = ibanReceiver;
        this.amount = amount;
    }

    public String getIbanInitiator() {
        return ibanInitiator;
    }

    public String getIbanReceiver() {
        return ibanReceiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ibanInitiator='" + ibanInitiator + '\'' +
                ", ibanReceiver='" + ibanReceiver + '\'' +
                ", amount=" + amount +
                '}';
    }
}
