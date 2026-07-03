package com.parking.demo.service;

import com.parking.demo.model.*;
import com.parking.demo.repository.ParkingSlotRepository;
import com.parking.demo.repository.ParkingTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
        ParkingSlot slot= defualtAllocator.findSlot(vehicle.getType()).orElseThrow(()-> new RuntimeException("Slot not found"));
        slot.park(vehicle);
        ParkingTicket ticket= new ParkingTicket(vehicle.getId(), slot.getSlotId());
        parkingTicketRepository.save(ticket);
        return ticket;
    }

    public ParkingTicket exit(String ticketId){
        ParkingTicket ticket =
                parkingTicketRepository
                        .findById(ticketId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Ticket not found"
                                )
                        );
        ticket.complete(pricingEngine.calculateFare(ticket));
        String slotId= ticket.getSlotId();
        ParkingSlot slot= parkingSlotRepository.findById(slotId);
        slot.unpark();
        return ticket;
    }
}
