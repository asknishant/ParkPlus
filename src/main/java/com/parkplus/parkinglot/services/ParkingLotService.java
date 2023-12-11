package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.models.ParkingLot;
import com.parkplus.parkinglot.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {
    ParkingLotRepository parkingLotRepository;

    public ParkingLot create(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot get(Long id) {
        return ParkingLot.builder().build();
    }
}
