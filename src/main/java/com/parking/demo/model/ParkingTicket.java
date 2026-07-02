package com.parking.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ParkingTicket {
    String ticketId;
    String vehicleId;
    String slotId;
    Instant inTime;
    Instant outTime;

    TicketStatus status;

    public ParkingTicket(String vehicleId, String slotId){
        this.ticketId= UUID.randomUUID().toString();
        this.vehicleId= vehicleId;
        this.slotId= slotId;
        this.inTime= Instant.now();
        this.status= TicketStatus.OPEN;
    }

}
