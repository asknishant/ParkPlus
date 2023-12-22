package com.parkplus.parkinglot.repository;

import com.parkplus.parkinglot.models.ParkingSpot;
import com.parkplus.parkinglot.models.SpotStatus;
import com.parkplus.parkinglot.models.SpotType;
import com.parkplus.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type) {
        System.out.println(parkingSpots.size());
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getSpotType() == SpotType.MEDIUM) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot update(ParkingSpot filledSpot) {
        System.out.println("Filled spot:" + filledSpot);
        ParkingSpot currentSpot = parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(filledSpot.getId()))
                .findFirst()
                .get();

        parkingSpots.remove(currentSpot);
        parkingSpots.add(filledSpot);

        return filledSpot;
    }

    public void saveAll(List<ParkingSpot> spots) {
        parkingSpots.addAll(spots);
        System.out.println("Parking Spots: " + parkingSpots);
    }

    public List<ParkingSpot> findAllByParkingLotId(Long id) {
        return parkingSpots;
    }

    public ParkingSpot findOneById(Long id) {
        return parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(id))
                .findFirst()
                .get();
    }

    public void empty(ParkingSpot ps) {
        parkingSpots
            .stream()
            .filter(spot -> spot.getId().equals(ps.getId()))
            .findFirst()
            .get().setSpotStatus(SpotStatus.AVAILABLE);
    }
}
