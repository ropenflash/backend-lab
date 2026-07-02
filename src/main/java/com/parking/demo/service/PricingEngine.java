package com.parking.demo.service;

import com.parking.demo.model.ParkingTicket;
import org.springframework.stereotype.Component;

@Component
public class PricingEngine {

    PricingStrategy strategy;

    public PricingEngine(PricingStrategy strategy){
        this.strategy=strategy;
    }

    double calculateFare(ParkingTicket ticket){
       return strategy.calculateFare(ticket);
    }
}
