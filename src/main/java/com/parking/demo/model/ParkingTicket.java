package com.parking.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ParkingTicket {
    String ticketId;
    String vehicleId;
    String slotId;

    private final String lotId;
    Instant entryTime;
    Instant exitTime;

    Double fare;

    TicketStatus status;

    public ParkingTicket(String vehicleId, String lotId, String slotId){
        this.ticketId= UUID.randomUUID().toString();
        this.vehicleId= vehicleId;
        this.slotId= slotId;
        this.lotId= lotId;
        this.entryTime= Instant.now();
        this.status= TicketStatus.OPEN;
    }

    private void close() {
        if (status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket already closed");
        }

        this.exitTime = Instant.now();
        this.status = TicketStatus.CLOSED;
    }

    public long getDurationInMinutes() {
        return Duration.between(entryTime, exitTime).toMinutes();
    }

    public void complete(double fare) {

        close();

        this.fare = fare;
    }

}
