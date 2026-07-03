package com.parking.demo.service;

import com.parking.demo.model.*;
import com.parking.demo.repository.ParkingSlotRepository;
import com.parking.demo.repository.ParkingTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ParkingManager {

    @Autowired
    DefaultAllocator defualtAllocator;

    @Autowired
    ParkingTicketRepository parkingTicketRepository;

    @Autowired
    PricingEngine pricingEngine;

    @Autowired
    ParkingSlotRepository parkingSlotRepository;



    public ParkingTicket park(Vehicle vehicle){
        Optional<ParkingSlot> slotOptional= defualtAllocator.findSlot(vehicle.getType());
        ParkingSlot slot= slotOptional.get();
        slot.assignVehicle(vehicle);
        ParkingTicket ticket= new ParkingTicket(vehicle.getId(), slot.getSlotId());
        parkingTicketRepository.save(ticket);
        return ticket;
    }

    public ParkingTicket exit(String ticketId){
        Optional<ParkingTicket> ticket= parkingTicketRepository.findById(ticketId);
        ParkingTicket ticket1= ticket.get();
        ticket1.close();
        Double fare= pricingEngine.calculateFare(ticket1);
        ticket1.setFare(fare);
        String slotId= ticket1.getSlotId();
        ParkingSlot slot= parkingSlotRepository.findById(slotId);
        slot.unpark();
        return ticket1;
    }
}
