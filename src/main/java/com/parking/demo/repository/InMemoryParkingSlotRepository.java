package com.parking.demo.repository;

import com.parking.demo.model.ParkingSlot;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryParkingSlotRepository implements ParkingSlotRepository{

    List<ParkingSlot> parkingSlotList= new ArrayList<>();
    Map<String, ParkingSlot> parkingSlotMap= new HashMap();
    @Override
    public void save(ParkingSlot slot) {
        parkingSlotList.add(slot);
        parkingSlotMap.put(slot.getSlotId(), slot);
    }

    @Override
    public ParkingSlot findById(String slotId) {
        return parkingSlotMap.get(slotId);
    }

    @Override
    public void updateParkingSlot(ParkingSlot slot) {
        slot.exitVehicle();
    }

    @Override
    public List<ParkingSlot> findAll() {
        return parkingSlotList;
    }
}
