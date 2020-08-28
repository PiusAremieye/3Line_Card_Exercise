package com.threeline.card_verification.service.implementation;

import com.threeline.card_verification.model.Card;
import com.threeline.card_verification.service.CardVerificationService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.threeline.card_verification.dto.CardResponseDto;
import com.threeline.card_verification.dto.CountDto;
import com.threeline.card_verification.dto.Payload;
import com.threeline.card_verification.exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardVerificationServiceImpl implements CardVerificationService {
    private LinkedHashMap<String, Integer> countPayload = new LinkedHashMap<>();
    private int count = 0;

    @Override
    public CardResponseDto validate(String cardNumber) {
        try {
            ResponseEntity<Card> responseEntity = new RestTemplate()
                    .getForEntity("https://lookup.binlist.net/{cardNumber}", Card.class, cardNumber);
            Card response = responseEntity.getBody();
            Payload payload = new Payload(response.getScheme(), response.getType(), response.getBank().getName());
            // update payload of number of hits
            addNumberOfHits(cardNumber);
            return new CardResponseDto(true, payload);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    protected void addNumberOfHits(String cardNumber) {
        if (!countPayload.containsKey(cardNumber)) {
            countPayload.put(cardNumber, 1);
        } else {
            count = countPayload.get(cardNumber) + 1;
            countPayload.put(cardNumber, count);
        }

    }

    @Override
    public CountDto countHit(int start, int limit) {
        try {
            LinkedHashMap<String, Integer> payload = new LinkedHashMap<>();
            if (countPayload.size() > 0) {
                List<String> list = new ArrayList<>();
                for (String key : countPayload.keySet()) {
                    list.add(key);
                }

                if (start == 0) {
                    start = 1;
                } else if (start > countPayload.size()) {
                    throw new CustomException("Start number way too high, please reduce start numbeer",
                            HttpStatus.BAD_REQUEST);
                }

                int end;
                if ((start + limit) > countPayload.size()) {
                    end = countPayload.size() + 1;
                } else {
                    end = start + limit;
                }

                for (int i = start; i < end; i++) {
                    payload.put(list.get(i - 1), countPayload.get(list.get(i - 1)));
                }
            }
            return new CountDto(true, start, limit, countPayload.size(), payload);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}