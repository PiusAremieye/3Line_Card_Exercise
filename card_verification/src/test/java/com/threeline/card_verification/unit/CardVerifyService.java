package com.threeline.card_verification.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.threeline.card_verification.service.CardVerificationService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CardVerifyService {
    private String cardNumber = "43958777747";

    private int start = 1;

    private int limit = 3;

    @MockBean
    private CardVerificationService cardVerificationService;

    @Before
    public void setup() {

    }

    @Test
    public void verifyCard() {
        cardVerificationService.validate(cardNumber);
        verify(cardVerificationService, times(1)).validate(cardNumber);
    }

    @Test
    public void countHits() {
        cardVerificationService.countHit(start, limit);
        verify(cardVerificationService, times(1)).countHit(start, limit);
    }
}