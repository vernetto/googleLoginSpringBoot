package org.pierre.shareazade.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.ShareException;
import org.pierre.shareazade.converters.EntityDTOConverter;
import org.pierre.shareazade.dtos.CityDTO;
import org.pierre.shareazade.dtos.RideEntryDTO;
import org.pierre.shareazade.dtos.UserDTO;
import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.services.CityService;
import org.pierre.shareazade.services.RideEntryService;
import org.pierre.shareazade.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
public class ShareController {


    private final RideEntryService rideEntryService;
    private final CityService cityService;
    private final UserService userService;
    private final EntityDTOConverter entityDTOConverter;

    @GetMapping("/ride/getAll")
    public List<RideEntryDTO> getAllRides() {
        return entityDTOConverter.convertRideEntryEntityToDTOList(rideEntryService.findAll());
    }

    @GetMapping("/city/getAll")
    public List<CityDTO> getAllCities() {
        return entityDTOConverter.convertCityEntityToDTOList(cityService.findAll());
    }


    @PostMapping("/city/add")
    public void createCity(@RequestBody CityDTO cityDTO) throws ShareException {
        cityDTO.setId(null);
        CityEntity cityEntity = entityDTOConverter.convertCityDTOToEntity(cityDTO);
        cityService.createCity(cityEntity);
    }

    @PostMapping("/user/add")
    public void createUser(@RequestBody UserDTO userDTO) {
        userDTO.setId(null);
        UserEntity userEntity = entityDTOConverter.convertUserDTOToEntity(userDTO);
        userService.createUser(userEntity);
    }

}
