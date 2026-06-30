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

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.slotStatus = Slotstatus.OCCUPIED;
    }

    public boolean isAvailable() {
        return slotStatus == Slotstatus.EMPTY;
    }

    public String getSlotId(){
        return this.slotId;
    }
}