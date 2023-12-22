package com.parkplus.parkinglot.repository;

import com.parkplus.parkinglot.models.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingLotRepository {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        System.out.println(parkingLots.size());
        return parkingLot;
    }

    public List<ParkingLot> findAll() {return parkingLots;}

    public ParkingLot findById(Long id) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.getId().equals(id)).findFirst().orElse(null);
    }
}
