package com.parking.demo.model;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class ParkingLot {
    String lotId;
    List<ParkingFloor> floors;

    public ParkingLot(String lotId, List<ParkingFloor> parkingFloors){
        this.lotId=lotId;
        this.floors=parkingFloors;
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType){
        for (ParkingFloor floor : floors) {

            Optional<ParkingSlot> slot =
                    floor.findAvailableSlot(vehicleType);

            if (slot.isPresent()) {
                return slot.get();
            }
        }


        return null;
    }

    public  ParkingSlot findSlot(String slotId){
        for(ParkingFloor floor: floors){
            ParkingSlot slot= floor.findSlot(slotId).orElseThrow(()-> new RuntimeException("NO slot found"));
            if (slot != null) {
                return slot;
            }
        }
        return  null;
    }
}
