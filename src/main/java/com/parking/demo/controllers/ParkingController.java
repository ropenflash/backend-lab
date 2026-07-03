package com.parking.demo.controllers;

import com.parking.demo.dto.ExitRequest;
import com.parking.demo.dto.ExitResponse;
import com.parking.demo.dto.ParkingRequest;
import com.parking.demo.dto.ParkingResponse;
import com.parking.demo.model.ParkingTicket;
import com.parking.demo.model.Vehicle;
import com.parking.demo.service.ParkingManager;
import com.sun.jdi.request.MethodExitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

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

    @PostMapping("/exit")
    public ResponseEntity<ExitResponse> exitVehicle(@RequestBody ExitRequest request){
        ExitResponse exitResponse= new ExitResponse();
        ParkingTicket parkingTicket= parkingManager.exit(request.getTicketId());
        exitResponse.setTicketId(parkingTicket.getTicketId());
        exitResponse.setAmount(parkingTicket.getFare());
        exitResponse.setDurationInMinutes(parkingTicket.getDurationInMinutes());
        exitResponse.setExitTime(parkingTicket.getExitTime());

       return  ResponseEntity.ok(exitResponse);
    }
}
