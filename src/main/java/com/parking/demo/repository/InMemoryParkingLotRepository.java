package com.parking.demo.repository;

import com.parking.demo.model.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryParkingLotRepository implements ParkingLotRepository{
    List<ParkingLot> parkingLots= new ArrayList<>();
    Map<String, ParkingLot> parkingLotMap= new HashMap<>();
    @Override
    public void save(ParkingLot lot) {
        parkingLots.add(lot);
        parkingLotMap.put(lot.getLotId(), lot);
    }

    @Override
    public ParkingLot findById(String id) {
        return parkingLotMap.get(id);
    }

    @Override
    public List<ParkingLot> findAll() {
        return parkingLots;
    }
}
