package org.pierre.shareazade.converters;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.pierre.shareazade.dtos.CityDTO;
import org.pierre.shareazade.dtos.RideEntryDTO;
import org.pierre.shareazade.dtos.UserDTO;
import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.entities.RideEntryEntity;
import org.pierre.shareazade.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EntityDTOConverter {
    private final ModelMapper modelMapper;

    public RideEntryDTO convertRideEntryEntityToDTO(RideEntryEntity rideEntryEntity) {
        return modelMapper.map(rideEntryEntity, RideEntryDTO.class);
    }

    public List<RideEntryDTO> convertRideEntryEntityToDTOList(List<RideEntryEntity> rideEntryEntityList) {
        List<RideEntryDTO> rideEntryDTOList = modelMapper.map(rideEntryEntityList, new TypeToken<List<RideEntryDTO>>() {}.getType());
        return rideEntryDTOList;
    }

    public CityEntity convertCityDTOToEntity(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, CityEntity.class);
    }

    public UserEntity convertUserDTOToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO convertUserEntityToDTOs(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<CityDTO> convertCityEntityToDTOList(List<CityEntity> cityEntityList) {
        List<CityDTO> cityEntityDTOList = modelMapper.map(cityEntityList, new TypeToken<List<CityDTO>>() {}.getType());
        return cityEntityDTOList;
    }
}
