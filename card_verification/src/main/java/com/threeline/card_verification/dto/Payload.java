package com.threeline.card_verification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payload {
    private String scheme;

    private String type;

    private String name;
}