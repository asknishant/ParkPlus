package com.parkplus.parkinglot.services;

import com.parkplus.parkinglot.models.ParkingLot;
import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.VehicleType;
import com.parkplus.parkinglot.repository.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot allocateSpot(VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot update(ParkingSpot filledSpot) {
        return parkingSpotRepository.update(filledSpot);
    }

    public void createParkingSpots(ParkingLot lot) {
        List<ParkingSpot> parkingSpots = lot.getFloors()
                .stream()
                .flatMap(floor -> floor.getSpots().stream().filter(parkingSpot -> parkingSpot.getSpotStatus().equals("AVAILABLE")))
                .collect(Collectors.toList());
        parkingSpotRepository.saveAll(parkingSpots);
    }

    public ParkingSpot markSlotBooked(ParkingSpot spot) {
        parkingSpotRepository.save(spot);
        return spot;
    }

    public List<ParkingSpot> getParkingSpots(Long id) {
        return parkingSpotRepository.findAllByParkingLotId(id);
    }

    public ParkingSpot getParkingSpot(Long id) {
        return parkingSpotRepository.findOneById(id);
    }

    public void emptyParkingSpots(ParkingSpot ps) {
        parkingSpotRepository.empty(ps);
    }

}
