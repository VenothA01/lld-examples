package com.dailycoder.parkinglot.model.ParkingSpot;

import com.dailycoder.parkinglot.model.ParkingSpot.enums.ParkingSpotType;

public class ElectricCarSpot extends ParkingSpot {

    public ElectricCarSpot(String parkingSpotID) {
        super(parkingSpotID, ParkingSpotType.ELECTRIC_CAR);
    }
}
