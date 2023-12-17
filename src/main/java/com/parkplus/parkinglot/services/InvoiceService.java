package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.models.Invoice;
import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.Vehicle;
import com.parkplus.parkinglot.repository.InvoiceRepository;
import com.parkplus.parkinglot.strategy.parkingstrategy.ParkingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceService {
    InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Vehicle vehicle) {
        Invoice invoice = Invoice.builder()
                .vehicle(vehicle)
                .parkingSpots(vehicle.getParkingSpots())
                .totalAmount(calculateTotalAmount(vehicle))
                .build();

        invoiceRepository.save(invoice);
        return invoice;
    }

    public Integer calculateTotalAmount(Vehicle vehicle) {
        int totalAmount = 0;
        for(ParkingSpot p : vehicle.getParkingSpots()) {
            totalAmount += ParkingStrategy.calc(vehicle, p);
        }
        return totalAmount;
    }

}
