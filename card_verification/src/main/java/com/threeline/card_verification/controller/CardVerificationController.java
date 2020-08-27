package com.threeline.card_verification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threeline.card_verification.apiresponse.ApiResponse;
import com.threeline.card_verification.dto.CardResponseDto;
import com.threeline.card_verification.dto.CountDto;
import com.threeline.card_verification.service.CardVerificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class CardVerificationController {

    private final CardVerificationService cardVerificationService;

    @Autowired
    public CardVerificationController(CardVerificationService cardVerificationService) {
        this.cardVerificationService = cardVerificationService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/card-scheme/verify/{cardNumber}")
    public ResponseEntity<ApiResponse<CardResponseDto>> cardValidity(
            @PathVariable(name = "cardNumber") String cardNumber) {
        CardResponseDto response = cardVerificationService.validate(cardNumber);
        ApiResponse<CardResponseDto> api = new ApiResponse<>(HttpStatus.OK);
        api.setData(response);
        api.setMessage("Card is valid");
        return new ResponseEntity<>(api, api.getStatus());
    }

    @GetMapping("/card-scheme/stats")
    public ResponseEntity<ApiResponse<CountDto>> hitCount(@RequestParam(name = "start", defaultValue = "1") int start,
            @RequestParam(name = "limit", defaultValue = "1") int limit) {
        CountDto response = cardVerificationService.countHit(start, limit);
        ApiResponse<CountDto> api = new ApiResponse<>(HttpStatus.OK);
        api.setData(response);
        api.setMessage("Number of hits returned");
        return new ResponseEntity<>(api, api.getStatus());
    }
}