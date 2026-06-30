package com.parking.demo.service;

import com.parking.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ParkingManager {

    @Autowired
    DefaultAllocator defualtAllocator;

    List<ParkingSlot> slots = new ArrayList<>();


    public ParkingManager(){
        slots.add(new ParkingSlot("C1", VehicleType.CAR ));
        slots.add(new ParkingSlot("C2", VehicleType.CAR));
        slots.add(new ParkingSlot("C3", VehicleType.BIKE ));
    }

    public ParkingTicket park(Vehicle vehicle){
        Optional<ParkingSlot> slotOptional= defualtAllocator.findSlot(slots, vehicle.getType());
        ParkingSlot slot= slotOptional.get();
        slot.assignVehicle(vehicle);
        ParkingTicket ticket= new ParkingTicket(vehicle.getId(), slot.getSlotId());
        return ticket;
    }
}
