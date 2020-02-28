package de.baitando.spring.samples.springhateoas.controller;

import de.baitando.spring.samples.springhateoas.controller.data.AccountDetailResponse;
import de.baitando.spring.samples.springhateoas.controller.data.PaymentDetailResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PaymentController {

    /**
     * REST controller providing access to the payment resource.
     */
    @GetMapping(path = "/payments/{paymentId}")
    public PaymentDetailResponse getPaymentById(@PathVariable Long paymentId) {

        AccountDetailResponse initiator = new AccountDetailResponse(1234L, "DExyfddsf");
        AccountDetailResponse counterparty = new AccountDetailResponse(4321L, "DEuimkxk");

        PaymentDetailResponse payment = new PaymentDetailResponse(paymentId, initiator, counterparty, 15.32D);

        // This is the part where the references are registered. Spring resolves these references to URLs
        // which are delivered as part of the response body.
        payment.add(linkTo(methodOn(PaymentController.class).getPaymentById(payment.getId()))
                .withSelfRel());
        payment.add(linkTo(methodOn(AccountController.class).getAccountById(initiator.getId()))
                .withRel("initiator"));
        payment.add(linkTo(methodOn(AccountController.class).getAccountById(counterparty.getId()))
                .withRel("counterparty"));

        return payment;
    }
}
