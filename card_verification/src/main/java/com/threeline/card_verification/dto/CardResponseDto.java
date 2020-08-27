package com.threeline.card_verification.dto;

import lombok.Data;

@Data
public class CardResponseDto {
    private boolean success;

    private Payload payload;

    public CardResponseDto(boolean sucess, Payload payload) {
        this.success = sucess;
        this.payload = payload;
    }

}