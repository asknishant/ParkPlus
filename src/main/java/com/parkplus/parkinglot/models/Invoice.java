package com.parkplus.parkinglot.models;

import com.parkplus.parkinglot.strategy.parkingstrategy.ParkingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseModel {
    private List<ParkingSpot> parkingSpots; // list of ps where the vehicle has taken cover.
    private Integer totalAmount;
    private Vehicle vehicle;
}

