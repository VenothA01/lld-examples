package com.dailycoder.parkinglot.model.ParkingSpot;

import com.dailycoder.parkinglot.model.ParkingSpot.enums.ParkingSpotType;
import com.dailycoder.parkinglot.model.vehicle.Vehicle;

public abstract class ParkingSpot {

    private String parkingSpotID;
    private boolean isSpotAvailable;
    private Vehicle vehicle;
    private ParkingSpotType type;

    public ParkingSpot(String parkingSpotID,ParkingSpotType type){
        this.parkingSpotID = parkingSpotID;
        this.isSpotAvailable=true;
        this.vehicle=null;
        this.type=type;
    }

    public String getParkingSpotID() {
        return parkingSpotID;
    }

    public boolean isSpotAvailable() {
        return isSpotAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void assignVehicleToSpot(Vehicle vehicle) {
        if (!this.isSpotAvailable) {
            throw new RuntimeException("No spots are available for ");
        }
        this.vehicle = vehicle;
        this.isSpotAvailable = false;
    }

    public  void vacateVehicleFromSpot(){
        this.vehicle=null;
        this.isSpotAvailable=true;
    }
}
