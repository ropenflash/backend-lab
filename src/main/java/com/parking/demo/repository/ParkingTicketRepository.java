package com.parking.demo.repository;

import com.parking.demo.model.ParkingTicket;

import java.util.Optional;

public interface ParkingTicketRepository {
    void save(ParkingTicket ticket);
    Optional<ParkingTicket> findById(String id);
    void closeTicket(String ticketId);
}
