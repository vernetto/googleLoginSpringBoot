package org.pierre.shareazade.services;

import lombok.AllArgsConstructor;
import org.pierre.shareazade.ShareException;
import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityEntity getCity(Long id) {
        return cityRepository.findById(id).get();
    }

    public CityEntity createCity(CityEntity cityEntity) throws ShareException {
        List<CityEntity> allCities = findAll();
        List<CityEntity> alreadyExistingCity = allCities.stream().filter(city -> city.getCityName().toLowerCase().equals(cityEntity.getCityName().toLowerCase())).collect(Collectors.toList());
        if (alreadyExistingCity.isEmpty()) {
        return cityRepository.save(cityEntity);
        }
        else {
            throw new ShareException("City already exists");
        }
    }

    public List<CityEntity> findAll() {
        return cityRepository.findAll();
    }

}
