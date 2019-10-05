package de.baitando.spring.samples.aop;

import java.math.BigDecimal;

public class Payment {
    private String ibanInitiator;
    private String ibanReceiver;
    private BigDecimal amount;

    public Payment(String ibanInitiator, String ibanReceiver, BigDecimal amount) {
        this.ibanInitiator = ibanInitiator;
        this.ibanReceiver = ibanReceiver;
        this.amount = amount;
    }

    public String getIbanInitiator() {
        return ibanInitiator;
    }

    public void setIbanInitiator(String ibanInitiator) {
        this.ibanInitiator = ibanInitiator;
    }

    public String getIbanReceiver() {
        return ibanReceiver;
    }

    public void setIbanReceiver(String ibanReceiver) {
        this.ibanReceiver = ibanReceiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
