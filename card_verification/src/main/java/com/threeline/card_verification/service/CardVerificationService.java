package com.threeline.card_verification.service;

import com.threeline.card_verification.dto.CardResponseDto;
import com.threeline.card_verification.dto.CountDto;

public interface CardVerificationService {

    public CardResponseDto validate(String cardNumber);

    public CountDto countHit(int size, int limit);

}