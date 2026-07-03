package com.parking.demo.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ExitResponse {

    private String ticketId;

    private double amount;

    private long durationInMinutes;

    private Instant exitTime;
}