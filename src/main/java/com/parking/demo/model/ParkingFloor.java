package com.parking.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor {
    String floorId;
    List<ParkingSlot> slots;

    public ParkingFloor(String floorId, List<ParkingSlot> slots){
        this.floorId=floorId;
        this.slots=slots;
    }

    ParkingSlot findAvailableSlot(VehicleType vehicleType){
        return slots.stream().filter(slot-> slot.canPark(vehicleType)).findFirst().orElseThrow(()-> new RuntimeException("No slot Avaialble"));
    }
}
