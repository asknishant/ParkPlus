package com.parkplus.parkinglot.dtos;

import com.parkplus.parkinglot.models.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateExitRequest {
    private Vehicle vehicle;
    private ExitGate exitGate;
    private ParkingOperator parkingOperator;
}
