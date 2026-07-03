package com.parking.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    String lotId;
    List<ParkingFloor> floors;

    public ParkingLot(String lotId, List<ParkingFloor> parkingFloors){
        this.lotId=lotId;
        this.floors=parkingFloors;
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType){
        for(ParkingFloor floor: floors){
            return floor.findAvailableSlot(vehicleType);
        }
        return null;
    }
}
