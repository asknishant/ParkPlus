package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.models.Vehicle;
import com.parkplus.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle
            .builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
    }
}
