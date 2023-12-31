package org.pierre.shareazade.repositories;

import org.pierre.shareazade.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

    CityEntity findByCityName(String name);
}
