package com.parking.demo.repository;

import com.parking.demo.model.ParkingTicket;
import com.parking.demo.model.TicketStatus;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryTicketRepository implements ParkingTicketRepository{
    List<ParkingTicket> parkingTickets= new ArrayList<>();
    Map<String, ParkingTicket> parkingTicketMap= new HashMap<>();
    @Override
    public void save(ParkingTicket parkingTicket) {
        parkingTickets.add(parkingTicket);
        parkingTicketMap.put(parkingTicket.getTicketId(), parkingTicket);
    }

    @Override
    public Optional<ParkingTicket> findById(String id) {
        return Optional.ofNullable(parkingTicketMap.get(id));
    }

    @Override
    public void closeTicket(String ticketId) {
       ParkingTicket ticket=  parkingTicketMap.get(ticketId);
       ticket.setStatus(TicketStatus.CLOSED);
    }
}
