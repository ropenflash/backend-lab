package com.parking.demo.repository;

import com.parking.demo.model.ParkingSlot;

import java.util.List;

public interface ParkingSlotRepository {
    void save (ParkingSlot slot);
    ParkingSlot findById(String slotId);
    void updateParkingSlot(ParkingSlot slot);

    List<ParkingSlot> findAll();
}
