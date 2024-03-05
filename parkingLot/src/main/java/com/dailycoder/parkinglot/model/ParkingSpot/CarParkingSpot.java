package com.dailycoder.parkinglot.model.ParkingSpot;

import com.dailycoder.parkinglot.model.ParkingSpot.enums.ParkingSpotType;

public class CarParkingSpot extends ParkingSpot {

    public CarParkingSpot(String parkingId){
        super(parkingId, ParkingSpotType.COMPACT);
    }
}
