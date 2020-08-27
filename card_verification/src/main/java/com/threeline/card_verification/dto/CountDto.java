package com.threeline.card_verification.dto;

import java.util.LinkedHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountDto {

    private boolean success;

    private int start;

    private int limit;

    private int size;

    private LinkedHashMap<String, Integer> payload;
}