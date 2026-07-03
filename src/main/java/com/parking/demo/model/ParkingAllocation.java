package com.parking.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingAllocation {
    ParkingLot parkingLot;
    ParkingSlot parkingSlot;


}
