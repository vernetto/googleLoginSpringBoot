package org.pierre.shareazade.services;

import lombok.AllArgsConstructor;
import org.pierre.shareazade.entities.RideEntryEntity;
import org.pierre.shareazade.repositories.RideEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RideEntryService {
    private final RideEntryRepository rideEntryRepository;

    public List<RideEntryEntity> findAll() {
        return rideEntryRepository.findAll();
    }

}
