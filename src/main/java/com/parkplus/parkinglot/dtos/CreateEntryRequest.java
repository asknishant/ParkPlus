package com.parkplus.parkinglot.dtos;

import com.parkplus.parkinglot.generators.TicketId;
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
        return Ticket.builder()
                .vehicle(vehicle)
                .parkingSpot(vehicle.getParkingSpots())
                .build();
    }
}

