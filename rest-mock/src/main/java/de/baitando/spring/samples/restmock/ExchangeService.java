package de.baitando.spring.samples.restmock;

import java.math.BigDecimal;
import java.util.Currency;

public interface ExchangeService {

    BigDecimal exchange(BigDecimal amount, Currency originCurrency, Currency targetCurrency);
}
