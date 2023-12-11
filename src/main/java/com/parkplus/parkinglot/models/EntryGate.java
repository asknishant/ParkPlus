package com.parkplus.parkinglot.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class EntryGate extends Gate {
    public String counterName;
    public Integer counterNumber;
}
