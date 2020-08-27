package com.threeline.card_verification.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.core.Is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.threeline.card_verification.controller.CardVerificationController;
import com.threeline.card_verification.service.CardVerificationService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardVerifyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardVerificationService cardVerificationService;

    @Test
    public void checkCardValidity() throws Exception {

        this.mockMvc.perform(get("/card-scheme/verify/47785885884").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.status", Is.is("OK")))
                .andExpect(jsonPath("$.message", Is.is("Card is valid")));
    }

    @Test
    public void numberOfHits() throws Exception {

        this.mockMvc
                .perform(get("/card-scheme/stats").param("page", "0").param("size", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.status", Is.is("OK")))
                .andExpect(jsonPath("$.message", Is.is("Number of hits returned")));
    }
}