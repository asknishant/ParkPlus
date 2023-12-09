package com.parkplus.parkinglot.dtos;

public class CreateParkingLotRequest  {
    private String name;
    private String address;
    private  Integer numberOfFloors;
    private Integer numberOfEntryGates;
    private Integer numberOfSpotsPerFloor;
    private Integer numberOfExitGates;

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
}
