package com.parking.demo.service;

import com.parking.demo.model.ParkingAllocation;
import com.parking.demo.model.VehicleType;

import java.util.Optional;

public interface SlotAllocator {

    public Optional<ParkingAllocation> findSlot(VehicleType vehicleType);
}
