package com.parking.demo.dto;

import com.parking.demo.model.VehicleType;
import lombok.Data;

@Data
public class ParkingRequest {
    VehicleType vehicleType;
    String vehicleId;
}
