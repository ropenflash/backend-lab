package com.parking.demo.service;

import com.parking.demo.model.ParkingSlot;
import com.parking.demo.model.VehicleType;
import com.parking.demo.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultAllocator implements SlotAllocator{

    @Autowired
    ParkingSlotRepository parkingSlotRepository;
    @Override
    public Optional<ParkingSlot> findSlot(VehicleType vehicleType) {
        return parkingSlotRepository.findAll().stream().filter(slot-> slot.canPark(vehicleType)).findFirst();
    }
}
