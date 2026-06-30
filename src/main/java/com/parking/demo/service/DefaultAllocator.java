package com.parking.demo.service;

import com.parking.demo.model.ParkingSlot;
import com.parking.demo.model.VehicleType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultAllocator implements SlotAllocator{
    @Override
    public Optional<ParkingSlot> findSlot(List<ParkingSlot> parkingSlotList, VehicleType vehicleType) {
        return parkingSlotList.stream().filter(slot-> slot.canPark(vehicleType)).findFirst();
    }
}
