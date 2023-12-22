package com.parkplus.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class TicketId {
    private static AtomicLong idCounter = new AtomicLong();
    public static Long nextId() {
        return idCounter.getAndIncrement();
    }
}
