package com.dailycoder.parkinglot.model.ParkingSpot;

import com.dailycoder.parkinglot.model.ParkingSpot.enums.ParkingSpotType;

public class MotorCycleParkingSpot extends ParkingSpot {

    public MotorCycleParkingSpot(String parkingSpotID) {
        super(parkingSpotID, ParkingSpotType.MOTORCYCYLE);
    }
}
