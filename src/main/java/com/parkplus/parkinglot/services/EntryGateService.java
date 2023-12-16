package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.dtos.CreateEntryRequest;
import com.parkplus.parkinglot.exceptions.SlotNotAvailableException;
import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.SpotStatus;
import com.parkplus.parkinglot.models.Ticket;
import com.parkplus.parkinglot.models.Vehicle;
import com.parkplus.parkinglot.repository.ParkingSpotRepository;
import com.parkplus.parkinglot.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntryGateService {
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;
    private TicketRepository ticketRepository;
    public Ticket create(CreateEntryRequest request) {
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(request.getVehicle().getId(), request.getVehicle().getType());
        if(parkingSpot == null) {
            throw new SlotNotAvailableException(request.getVehicle().getType());
        }
        // Update the status of spot
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        // save it in db through parking spot service
        ParkingSpot updateSpot = parkingSpotService.update(parkingSpot);
        // Fetch and create
        // If vehicle number and type is present, use that
        // else create a new one.
        Vehicle vehicle = vehicleService.findOrCreate(request.getVehicle().getLicenseNumber(), request.getVehicle().getType());

        // Create a ticket and save it.
        Ticket ticket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(updateSpot)
                .vehicle(vehicle)
                .entryGateId(Long.valueOf(request.getEntryGate().counterNumber))
                .build();

        // create a ticket and save it.
        return ticketRepository.save(ticket);
    }
}
