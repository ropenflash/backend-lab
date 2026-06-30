package com.parking.demo.controllers;

import com.parking.demo.dto.ParkingRequest;
import com.parking.demo.dto.ParkingResponse;
import com.parking.demo.model.ParkingTicket;
import com.parking.demo.model.Vehicle;
import com.parking.demo.service.ParkingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingManager parkingManager;

    @GetMapping
    public String getParkingSlots(){
        return "hello";
    }

    @PostMapping
    public ResponseEntity<ParkingResponse> parkVehicle(@RequestBody ParkingRequest request){
        ParkingResponse response= new ParkingResponse();
        Vehicle vehicle= new Vehicle(request.getVehicleId(), request.getVehicleType());
        ParkingTicket ticket= parkingManager.park(vehicle);
        response.setTicketId(ticket.getTicketId());
        response.setSlotId(ticket.getSlotId());
        return ResponseEntity.ok().body(response);
    }
}
