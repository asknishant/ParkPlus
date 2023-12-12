package com.parkplus.parkinglot.exceptions;

import com.parkplus.parkinglot.models.VehicleType;

public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException(VehicleType vehicleType) {
        super("Slot Not Found  for vehicle type: " + vehicleType);
    }
}
