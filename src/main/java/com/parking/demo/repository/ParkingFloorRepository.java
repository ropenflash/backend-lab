package com.parking.demo.repository;

import com.parking.demo.model.ParkingFloor;

import java.util.List;

public interface ParkingFloorRepository {
    void save (ParkingFloor floor);
    ParkingFloor findById(String id);
    List<ParkingFloor> findAll();
}
