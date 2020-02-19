package de.baitando.spring.samples.springhateoas.controller;

import de.baitando.spring.samples.springhateoas.controller.data.AccountDetailResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * REST controller providing access to the {@link AccountDetailResponse } resource.
 */
@RestController
public class AccountController {

    @GetMapping("/accounts/{accountId}")
    public AccountDetailResponse getAccountById(@PathVariable Long accountId) {
        AccountDetailResponse account = new AccountDetailResponse(accountId, "DExyfddsf");
        account.add(linkTo(methodOn(AccountController.class).getAccountById(account.getId())).withSelfRel());

        return account;
    }
}
