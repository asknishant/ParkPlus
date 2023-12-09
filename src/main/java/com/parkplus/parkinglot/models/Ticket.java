package com.parkplus.parkinglot.models;
import java.util.Date;

public class Ticket extends BaseModel {
    private Long vehicleId;
    private Date entryTime;
    private Long spotId;
}
