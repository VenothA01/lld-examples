package com.dailycoder.parkinglot.model.ParkingSpot;

import com.dailycoder.parkinglot.model.ParkingSpot.enums.ParkingSpotType;

public class DisableParkingSpot extends ParkingSpot{

    public DisableParkingSpot(String parkingId) {
        super(parkingId, ParkingSpotType.DISABLED);
    }
}
