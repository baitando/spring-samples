# Rest Mock

This sample shows, how a service which depends on an external API can be tested in isolation by mocking the remote server.

* The `RestExchangeService` converts from one currency to another.
* Exchange rates are retrieved from [https://exchangeratesapi.io/](https://exchangeratesapi.io/) using a `RestTemplate`.
* The `ExchangeController` provides the conversion as REST API.
* The `RestExchangeServiceTest` mocks the REST API used to get the exchange rates.