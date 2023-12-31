package org.pierre.shareazade.services;

import lombok.AllArgsConstructor;
import org.pierre.shareazade.entities.RideEntryEntity;
import org.pierre.shareazade.repositories.RideEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RideEntryService {
    private final RideEntryRepository rideEntryRepository;

    public List<RideEntryEntity> findAll() {
        return rideEntryRepository.findAll();
    }


    public void createRide(RideEntryEntity rideEntryEntity) {
        rideEntryRepository.save(rideEntryEntity);
    }

    public Optional<RideEntryEntity> findById(Long rideId) {
        return rideEntryRepository.findById(rideId);
    }

    public List<RideEntryEntity> findAllFutureRides() {
        return rideEntryRepository.findAllFutureRides();
    }

    public void deleteRide(Long rideId) {
        rideEntryRepository.deleteById(rideId);
    }
}
