package com.parking.demo.repository;

import com.parking.demo.model.ParkingLot;

import java.util.List;

public interface ParkingLotRepository {
    void save(ParkingLot lot);
    ParkingLot findById(String id);
    List<ParkingLot> findAll();
}
