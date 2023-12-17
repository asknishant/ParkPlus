package com.parkplus.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot extends BaseModel {

    private String name;
    private String address;

    private List<ParkingFloor> floors = new ArrayList<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private List<ExitGate> exitGates = new ArrayList<>();
    private DisplayBoard displayBoard;
}