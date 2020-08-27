package com.threeline.card_verification.service;

import com.threeline.card_verification.dto.CardResponseDto;

public interface CardVerificationService {

    public CardResponseDto validate(int cardNumber);

}