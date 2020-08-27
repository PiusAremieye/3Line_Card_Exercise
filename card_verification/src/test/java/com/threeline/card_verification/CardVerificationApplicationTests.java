package com.threeline.card_verification;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.threeline.card_verification.controller.CardVerificationController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardVerificationApplicationTests {

	@Autowired
	private CardVerificationController cardVerification;

	@Test
	void contextLoads() {
		assertNotNull(cardVerification);
	}

}
