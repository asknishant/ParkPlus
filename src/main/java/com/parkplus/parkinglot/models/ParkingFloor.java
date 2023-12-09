package com.parkplus.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private List<ParkingSpot> spots = new ArrayList<>();
    private PaymentCounter paymentCounter;
}
