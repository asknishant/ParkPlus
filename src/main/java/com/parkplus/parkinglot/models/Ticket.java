package com.parkplus.parkinglot.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SuperBuilder
@Getter
public class Ticket extends BaseModel {
    private Long vehicleId;
    private Vehicle vehicle;

    private Long parkingSpotId;
    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;
    private Long issuerId;

    private ParkingOperator issuedBy;
    private Long entryGateId;
    private Long entryGate;
}
