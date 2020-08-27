package com.threeline.card_verification.model;

import lombok.Data;

@Data
public class Card {
    private Number number;

    private String scheme;

    private String type;

    private String brand;

    private boolean prepaid;

    private Country country;

    private Bank bank;

}