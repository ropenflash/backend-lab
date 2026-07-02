package com.parking.demo.service;

import com.parking.demo.model.ParkingTicket;

import java.time.Duration;

public class DefaultPricingStrategy implements PricingStrategy{

    @Override
    public double calculateFare(ParkingTicket parkingTicket) {
        long hours = Duration.between(parkingTicket.getInTime(), parkingTicket.getOutTime()).toHours();
        return hours * 20;
    }
}
