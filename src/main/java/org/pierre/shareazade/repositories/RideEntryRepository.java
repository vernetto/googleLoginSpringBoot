package org.pierre.shareazade.repositories;

import org.pierre.shareazade.entities.RideEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RideEntryRepository extends JpaRepository<RideEntryEntity, Long> {

    @Query("SELECT r FROM RideEntryEntity r WHERE r.rideDate > CURRENT_DATE")
    List<RideEntryEntity> findAllFutureRides();
}
