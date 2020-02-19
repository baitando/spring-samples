package de.baitando.spring.samples.springhateoas.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAccountById_withExistingId_returnsAccount() throws Exception {

        // arrange

        // act
        ResultActions result = mockMvc.perform(get("/accounts/{accountId}", 456L));

        // assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self.href").value("http://localhost/accounts/456"));
    }
}
