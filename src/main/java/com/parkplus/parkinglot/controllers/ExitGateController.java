package com.parkplus.parkinglot.controllers;

import com.parkplus.parkinglot.dtos.CreateExitRequest;
import com.parkplus.parkinglot.models.Invoice;
import com.parkplus.parkinglot.services.ExitGateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exit")
@AllArgsConstructor
public class ExitGateController {
    // call a service which calculates the total amount
    // total amount = amt1(at slot1) + amt2(at slot2) ...
    private ExitGateService exitGateService;
    @PostMapping
    public Invoice exitVehicle(@RequestBody CreateExitRequest createExitRequest) {
        return exitGateService.exit(createExitRequest);
    }
}
