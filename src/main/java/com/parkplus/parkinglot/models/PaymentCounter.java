package com.parkplus.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class PaymentCounter {
    public String counterName;
    public Integer counterNumber;
}
