package com.parking.demo.service;

import com.parking.demo.model.ParkingSlot;
import com.parking.demo.model.VehicleType;

import java.util.List;
import java.util.Optional;

public interface SlotAllocator {

    public Optional<ParkingSlot> findSlot(VehicleType vehicleType);
}
