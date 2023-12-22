package com.parkplus.parkinglot.models;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Getter
public class Ticket extends BaseModel {
    private Vehicle vehicle;
    private List<ParkingSpot> parkingSpot;

    private LocalDateTime entryTime;
    private ParkingOperator operator;

    private EntryGate entryGate;
}
