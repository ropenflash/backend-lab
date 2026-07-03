package com.parking.demo.repository;

import com.parking.demo.model.ParkingFloor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryParkingFloorRepository implements ParkingFloorRepository{
    List<ParkingFloor> floors= new ArrayList<>();
    Map<String, ParkingFloor> parkingFloorMap= new HashMap<>();
    @Override
    public void save(ParkingFloor floor) {
        floors.add(floor);
        parkingFloorMap.put(floor.getFloorId(), floor);
    }

    @Override
    public ParkingFloor findById(String id) {
        return parkingFloorMap.get(id);
    }

    @Override
    public List<ParkingFloor> findAll() {
        return floors;
    }
}
