package com.parking.demo.service;

import com.parking.demo.model.ParkingTicket;

public interface PricingStrategy {
    double calculateFare(ParkingTicket parkingTicket);
}
