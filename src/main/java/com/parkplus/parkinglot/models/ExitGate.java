package com.parkplus.parkinglot.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ExitGate extends Gate {
    public String counterName;
    public Integer counterNumber;
}
