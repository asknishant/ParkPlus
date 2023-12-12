package com.parkplus.parkinglot.controllers;

import com.parkplus.parkinglot.dtos.CreateTicketRequest;
import com.parkplus.parkinglot.models.Ticket;
import com.parkplus.parkinglot.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {
    // Creating a ticket
    // POST /ticket
    private TicketService ticketService;
    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request) {
        return ticketService.create(request);
    }
}
