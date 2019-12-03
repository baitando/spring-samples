package de.baitando.spring.samples.restmock.controller;

import de.baitando.spring.samples.restmock.ExchangeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

    private ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeResponse exchange(@RequestBody ExchangeRequest exchangeRequest) {
        BigDecimal exchangedAmount = exchangeService.exchange(exchangeRequest.getAmount(), exchangeRequest.getOriginCurrency(), exchangeRequest.getTargetCurrency());

        return new ExchangeResponse(exchangeRequest.getAmount(), exchangeRequest.getOriginCurrency(), exchangedAmount, exchangeRequest.getTargetCurrency());
    }
}
