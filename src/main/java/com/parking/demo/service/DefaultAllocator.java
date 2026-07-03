package com.parking.demo.service;

import com.parking.demo.model.*;
import com.parking.demo.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultAllocator implements SlotAllocator{

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public Optional<ParkingAllocation> findSlot(VehicleType vehicleType) {
        List<ParkingLot> parkingLots= parkingLotRepository.findAll();
        ParkingSlot slot= null;
        ParkingLot parkingLot= null;
        for(ParkingLot lot: parkingLots){
             slot= lot.findAvailableSlot(vehicleType);
             parkingLot=lot;

            }
        return Optional.of(new ParkingAllocation(parkingLot, slot));
    }

}
