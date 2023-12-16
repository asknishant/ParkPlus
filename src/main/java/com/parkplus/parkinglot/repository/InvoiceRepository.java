package com.parkplus.parkinglot.repository;

import com.parkplus.parkinglot.models.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {
    List<Invoice> invoices = new ArrayList<>();

    public Invoice save(Invoice invoice) {
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> findAll() {return invoices;}

    public Invoice findById(Long id) {
        return invoices.stream().filter(invoice -> invoice.getVehicle().getLicenseNumber().equals(id)).findFirst().orElse(null);
    }
}
