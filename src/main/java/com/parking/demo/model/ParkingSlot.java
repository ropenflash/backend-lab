package com.parking.demo.model;

import lombok.Data;

public  class ParkingSlot {

    private final String slotId;

    private final VehicleType supportedType;

    private Vehicle vehicle;

    private Slotstatus slotStatus;

    public ParkingSlot(String slotId, VehicleType supportedType){
        this.slotStatus= Slotstatus.EMPTY;
        this.slotId= slotId;
        this.supportedType= supportedType;
    }


    public boolean canPark(VehicleType vehicleType) {
        return supportedType == vehicleType && slotStatus== Slotstatus.EMPTY;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.slotStatus = Slotstatus.OCCUPIED;
    }

    public void exitVehicle(){
        this.vehicle=null;
        this.slotStatus= Slotstatus.EMPTY;
    }

    public void unpark() {

        if (slotStatus!=Slotstatus.OCCUPIED) {
            throw new IllegalStateException("Slot already empty");
        }

        this.vehicle = null;
        this.slotStatus = Slotstatus.EMPTY;
    }

    public boolean isAvailable() {
        return slotStatus == Slotstatus.EMPTY;
    }

    public String getSlotId(){
        return this.slotId;
    }
}