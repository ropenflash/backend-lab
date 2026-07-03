package com.parking.demo.model;

import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class ParkingFloor {
    String floorId;
    List<ParkingSlot> slots;

    public ParkingFloor(String floorId, List<ParkingSlot> slots){
        this.floorId=floorId;
        this.slots=slots;
    }

    Optional<ParkingSlot> findAvailableSlot(VehicleType vehicleType){
        return slots.stream().filter(slot-> slot.canPark(vehicleType)).findFirst();
    }

    Optional<ParkingSlot> findSlot(String id){
        return slots.stream().filter(slot-> slot.getSlotId().equals(id)).findFirst();
    }
}
