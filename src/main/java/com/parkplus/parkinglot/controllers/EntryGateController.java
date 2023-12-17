package com.parkplus.parkinglot.controllers;

import com.parkplus.parkinglot.dtos.CreateEntryRequest;
import com.parkplus.parkinglot.dtos.CreateParkingLotRequest;
import com.parkplus.parkinglot.models.ParkingLot;
import com.parkplus.parkinglot.models.Ticket;
import com.parkplus.parkinglot.services.EntryGateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class EntryGateController {
    // Creating a ticket
    // POST /ticket
    private EntryGateService entryGateService;
    @PostMapping
    public Ticket createTicket(@RequestBody CreateEntryRequest request) {
        Ticket ticket = transform(request);
        System.out.println(ticket);
        return entryGateService.create(ticket);
    }
    private Ticket transform(CreateEntryRequest request) {
        return request.toTicket();
    }
}
