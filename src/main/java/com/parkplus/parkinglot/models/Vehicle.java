package com.parkplus.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class Vehicle extends BaseModel {
    private String licenseNumber;
    private VehicleType type;
    private List<ParkingSpot> parkingSpots; // we need list of parking spots where the vehicle has paid
}