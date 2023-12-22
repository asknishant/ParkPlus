package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.exceptions.SlotNotAvailableException;
import com.parkplus.parkinglot.generators.TicketId;
import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.SpotStatus;
import com.parkplus.parkinglot.models.Ticket;
import com.parkplus.parkinglot.models.Vehicle;
import com.parkplus.parkinglot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryGateService {
    @Autowired
    private ParkingSpotService parkingSpotService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket create(Ticket ticket) {
        // get a parking spot from available parkingspots
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(ticket.getVehicle().getType());
        System.out.println(ticket.getParkingSpot()+ "my parking spot");
        if(parkingSpot.getSpotStatus() == SpotStatus.OCCUPIED) {
            throw new SlotNotAvailableException(ticket.getVehicle().getType());
        }
        // Update the status of spot
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        // save it in db through parking spot service
        ParkingSpot updateSpot = parkingSpotService.update(parkingSpot);
        //add it to a list of spots where the vehicle has taken spot
        List<ParkingSpot> savedSpots = vehicleService.saveVehicleSpot(updateSpot);
        // Fetch and create
        // If vehicle number and type is present, use that
        // else create a new one.
        Vehicle vehicle = vehicleService.findOrCreate(ticket.getVehicle());

        // Create a ticket and save it.
        Ticket newTicket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .id(TicketId.nextId())
                .parkingSpot(savedSpots)
                .vehicle(vehicle)
                .build();

        // create a ticket and save it.
        return ticketRepository.save(newTicket);
    }
}
