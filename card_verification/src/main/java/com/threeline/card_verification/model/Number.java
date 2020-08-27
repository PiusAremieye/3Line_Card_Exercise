package com.threeline.card_verification.model;

import lombok.Data;

@Data
public class Number {
    private int length;

    private boolean luhn;

}