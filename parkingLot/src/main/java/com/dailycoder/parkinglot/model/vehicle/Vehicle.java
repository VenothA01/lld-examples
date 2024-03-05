package com.dailycoder.parkinglot.model.vehicle;

import com.dailycoder.parkinglot.model.vehicle.enums.VehicleType;

public abstract class Vehicle {

    private String registeredNumber;
    private VehicleType vehicleType;

    public Vehicle(String registeredNumber,VehicleType vehicleType){
        this.registeredNumber=registeredNumber;
        this.vehicleType=vehicleType;
    }

}
