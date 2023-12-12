package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.dtos.CreateTicketRequest;
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
public class TicketService {
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;
    private TicketRepository ticketRepository;
    public Ticket create(CreateTicketRequest request) {
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(request.getParkingLotId(), request.getVehicleType());
        if(parkingSpot == null) {
            throw new SlotNotAvailableException(request.getVehicleType());
        }
        // Update the status of spot
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        // save it in db through parking spot service
        ParkingSpot updateSpot = parkingSpotService.update(parkingSpot);
        // Fetch and create
        // If vehicle number and type is present, use that
        // else create a new one.
        Vehicle vehicle = vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType());

        // Create a ticket and save it.
        Ticket ticket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(updateSpot)
                .vehicle(vehicle)
                .entryGateId(request.getEntryGateId())
                .build();

        // create a ticket and save it.
        return ticketRepository.save(ticket);
    }
}
