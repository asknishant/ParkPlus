package com.parkplus.parkinglot.controllers;

import com.parkplus.parkinglot.dtos.CreateParkingLotRequest;
import com.parkplus.parkinglot.models.ParkingLot;
import com.parkplus.parkinglot.services.ParkingLotService;

public class ParkingLotController  {
    // Create a parking lot
    // POST
    ParkingLotService parkingLotService = new ParkingLotService();
    public ParkingLot createParkingLot(CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors() < 0) {
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return new ParkingLot();
    }

}
