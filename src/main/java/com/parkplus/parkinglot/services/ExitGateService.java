package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.dtos.CreateExitRequest;
import com.parkplus.parkinglot.models.Invoice;
import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.SpotStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExitGateService {
    InvoiceService invoiceService; // this service is responsible for calc total amount after positioning.
    ParkingSpotService parkingSpotService;
    public Invoice exit(CreateExitRequest request) {
        // create Invoice
        Invoice invoice = invoiceService.createInvoice(request.getVehicle());
        // update all parkingspots
        List<ParkingSpot> psToBeUpdated = request.getVehicle().getParkingSpots();
        updateAllParkingSpots(psToBeUpdated);
        return invoice;
    }

    private void updateAllParkingSpots(List<ParkingSpot> psToBeUpdated) {
        for(ParkingSpot ps : psToBeUpdated) {
            if(ps.getSpotStatus() != SpotStatus.AVAILABLE)
                parkingSpotService.emptyParkingSpots(ps);
        }
    }
}
