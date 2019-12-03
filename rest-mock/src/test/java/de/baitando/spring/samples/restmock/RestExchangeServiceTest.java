package de.baitando.spring.samples.restmock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.baitando.spring.samples.restmock.internal.RestExchangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Currency;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(RestExchangeService.class)
public class RestExchangeServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RestExchangeService restExchangeService;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void init() {
        server = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void test() throws JsonProcessingException {
        // Arrange
        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRates.setBase("EUR");
        exchangeRates.setDate(LocalDate.now());
        exchangeRates.setRates(new HashMap<>());
        exchangeRates.getRates().put("USD", BigDecimal.valueOf(2));

        this.server.expect(requestTo("https://api.exchangeratesapi.io/latest?base=EUR&symbols=USD"))
                .andRespond(withSuccess().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(exchangeRates)));

        // Act
        BigDecimal result = restExchangeService.exchange(BigDecimal.valueOf(2), Currency.getInstance("EUR"), Currency.getInstance("USD"));

        // Assert
        assertThat(result).isEqualTo(BigDecimal.valueOf(4).setScale(2, RoundingMode.UNNECESSARY));
    }
}
