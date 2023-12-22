package com.parkplus.parkinglot.repository;

import com.parkplus.parkinglot.models.ParkingSpot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    List<ParkingSpot> spotListOfVehicle = new ArrayList<>();

    public List<ParkingSpot> saveSpots(ParkingSpot parkingSpot) {
        spotListOfVehicle.add(parkingSpot);
        return spotListOfVehicle;
    }
}
