package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.Vehicle;
import com.parkplus.parkinglot.models.VehicleType;
import com.parkplus.parkinglot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public List<ParkingSpot> saveVehicleSpot(ParkingSpot parkingSpot) {
        return vehicleRepository.saveSpots(parkingSpot);
    }

    public Vehicle findOrCreate(Vehicle vehicle) {
        return Vehicle
            .builder()
                .id(vehicle.getId())
                .licenseNumber(vehicle.getLicenseNumber())
                .type(vehicle.getType())
                .build();
    }
}
