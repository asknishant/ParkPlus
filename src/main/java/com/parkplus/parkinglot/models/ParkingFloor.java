package com.parkplus.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private List<ParkingSpot> spots = new ArrayList<>();
    private PaymentCounter paymentCounter;
}

