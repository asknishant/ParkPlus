package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.dtos.CreateEntryRequest;
import com.parkplus.parkinglot.exceptions.SlotNotAvailableException;
import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.SpotStatus;
import com.parkplus.parkinglot.models.Ticket;
import com.parkplus.parkinglot.models.Vehicle;
import com.parkplus.parkinglot.repository.ParkingSpotRepository;
import com.parkplus.parkinglot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntryGateService {
    private ParkingSpotRepository parkingSpotRepository;
    @Autowired
    private ParkingSpotService parkingSpotService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private TicketRepository ticketRepository;
    public Ticket create(Ticket ticket) {
        ParkingSpot parkingSpot = parkingSpotService.markSlotBooked(ticket.getParkingSpot());
        System.out.println(ticket.getParkingSpot().getSpotStatus() + "my parking spot");
        if(parkingSpot.getSpotStatus().equals("OCCUPIED")) {
            throw new SlotNotAvailableException(ticket.getVehicle().getType());
        }
        // Update the status of spot
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        // save it in db through parking spot service
        ParkingSpot updateSpot = parkingSpotService.update(parkingSpot);
        // Fetch and create
        // If vehicle number and type is present, use that
        // else create a new one.
        Vehicle vehicle = vehicleService.findOrCreate(ticket.getVehicle().getLicenseNumber(), ticket.getVehicle().getType());

        // Create a ticket and save it.
        Ticket newTicket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(updateSpot)
                .vehicle(vehicle)
                .entryGateId(ticket.getEntryGate())
                .build();

        // create a ticket and save it.
        return ticketRepository.save(newTicket);
    }
}
