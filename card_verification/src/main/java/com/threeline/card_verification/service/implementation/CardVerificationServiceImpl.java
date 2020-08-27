package com.threeline.card_verification.service.implementation;

import com.threeline.card_verification.model.Card;
import com.threeline.card_verification.service.CardVerificationService;

import com.threeline.card_verification.dto.CardResponseDto;
import com.threeline.card_verification.dto.Payload;
import com.threeline.card_verification.exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardVerificationServiceImpl implements CardVerificationService {

    @Override
    public CardResponseDto validate(int cardNumber) {
        try {
            ResponseEntity<Card> responseEntity = new RestTemplate()
                    .getForEntity("https://lookup.binlist.net/{cardNumber}", Card.class, cardNumber);
            Card response = responseEntity.getBody();
            Payload payload = new Payload(response.getScheme(), response.getType(), response.getBank().getName());
            return new CardResponseDto(true, payload);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}