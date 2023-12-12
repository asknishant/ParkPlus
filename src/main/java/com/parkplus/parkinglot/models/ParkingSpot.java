package com.parkplus.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ParkingSpot extends BaseModel {
    private SpotType spotType;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;

    public static ParkingSpot mediumAvailable() {
        return ParkingSpot.builder()
                .spotType(SpotType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }
}