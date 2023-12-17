package com.parkplus.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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