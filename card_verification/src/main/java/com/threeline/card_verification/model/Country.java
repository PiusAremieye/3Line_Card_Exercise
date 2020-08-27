package com.threeline.card_verification.model;

import lombok.Data;

@Data
public class Country {
    private String numeric;

    private String alpha2;

    private String name;

    private String emoji;

    private String currency;

    private String latitude;

    private String longitude;
}