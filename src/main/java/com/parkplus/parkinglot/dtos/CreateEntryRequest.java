package com.parkplus.parkinglot.dtos;

import com.parkplus.parkinglot.models.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateEntryRequest {
    private ParkingLot parkingLot;
    private Vehicle vehicle;
    private EntryGate entryGate;
    private ParkingOperator parkingOperator;

    public Ticket toTicket() {
        ParkingSpot parkingSpot = vehicle.getParkingSpots().get(0);
        System.out.println(parkingSpot + vehicle.getLicenseNumber() + " " + entryGate + " " + parkingOperator + " Print");
        return Ticket.builder()
                .vehicle(vehicle)
                .parkingSpot(parkingSpot)
                .build();
    }
}

