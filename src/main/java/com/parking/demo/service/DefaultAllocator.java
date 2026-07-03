package com.parking.demo.service;

import com.parking.demo.model.ParkingFloor;
import com.parking.demo.model.ParkingLot;
import com.parking.demo.model.ParkingSlot;
import com.parking.demo.model.VehicleType;
import com.parking.demo.repository.ParkingFloorRepository;
import com.parking.demo.repository.ParkingLotRepository;
import com.parking.demo.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultAllocator implements SlotAllocator{

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public Optional<ParkingSlot> findSlot(VehicleType vehicleType) {
        List<ParkingLot> parkingLots= parkingLotRepository.findAll();
        for(ParkingLot lot: parkingLots){
             return Optional.ofNullable(lot.findAvailableSlot(vehicleType));
            }
        return null;
    }

}
