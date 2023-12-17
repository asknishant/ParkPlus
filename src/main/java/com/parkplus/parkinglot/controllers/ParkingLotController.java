package com.parkplus.parkinglot.controllers;

import com.parkplus.parkinglot.dtos.CreateParkingLotRequest;
import com.parkplus.parkinglot.models.ParkingLot;
import com.parkplus.parkinglot.services.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parking-lot") // Map all the request of the url to this controller
@AllArgsConstructor
public class ParkingLotController  {
    // Create a parking lot
    // POST /api/v1/parking-lot
    ParkingLotService parkingLotService;
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    // GET /api/v1/parking-lot/{id}
    @GetMapping("/{id}")
    public ParkingLot getParkingLot(@PathVariable("id") Long id) {
        return ParkingLot.builder().id(id).build();
    }

    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors() < 0) {
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }
}