package de.baitando.spring.samples.restmock.internal;

import de.baitando.spring.samples.restmock.ExchangeRates;
import de.baitando.spring.samples.restmock.ExchangeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Service
public class RestExchangeService implements ExchangeService {

    private RestTemplate restTemplate;

    public RestExchangeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BigDecimal exchange(BigDecimal amount, Currency originCurrency, Currency targetCurrency) {

        ExchangeRates exchangeRates = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=" + originCurrency.getCurrencyCode() + "&symbols=" + targetCurrency.getCurrencyCode(), ExchangeRates.class);

        BigDecimal exchangeRate = exchangeRates.getRates().get(targetCurrency.getCurrencyCode());
        if (exchangeRate == null) {
            throw new RuntimeException("Target currency not found");
        }

        return exchangeRate.multiply(amount).setScale(2, RoundingMode.HALF_UP);
    }
}
