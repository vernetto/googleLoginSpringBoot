package org.pierre.shareazade.converters;

import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.repositories.CityRepository;
import org.pierre.shareazade.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCityEntityConverter implements Converter<String, CityEntity> {

    @Autowired
    private CityService cityService;

    @Override
    public CityEntity convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(source); // Assuming the source is the city ID
        return cityService.findById(id).orElse(null);
    }
}
