package com.parking.demo.service;

import com.parking.demo.model.*;
import com.parking.demo.repository.ParkingLotRepository;
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
    ParkingLotRepository parkingLotRepository;



    public ParkingTicket park(Vehicle vehicle){
        ParkingAllocation allocation= defualtAllocator.findSlot(vehicle.getType()).orElseThrow(()-> new RuntimeException("Slot not found"));
        ParkingSlot slot= allocation.getParkingSlot();
        slot.park(vehicle);
        ParkingTicket ticket= new ParkingTicket(vehicle.getId(), allocation.getParkingLot().getLotId() , slot.getSlotId());
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
        String lotId= ticket.getLotId();
        String slotId= ticket.getSlotId();
        ParkingSlot slot=  parkingLotRepository.findById(lotId).findSlot(slotId);
        slot.unpark();
        return ticket;
    }
}
