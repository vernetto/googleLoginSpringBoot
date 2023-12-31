package org.pierre.shareazade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.constants.RideType;
import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.entities.RideEntryEntity;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.repositories.RideEntryRepository;
import org.pierre.shareazade.services.CityService;
import org.pierre.shareazade.services.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@Component
@Slf4j
public class DataLoader implements ApplicationRunner {
    private final RideEntryRepository rideEntryRepository;
    private final CityService cityService;
    private final UserService userService;

    public void run(ApplicationArguments args) throws ShareException {
        if (!cityService.findAll().isEmpty()) return;
        log.info("creating sample data in DB");
        CityEntity cityEntity1 = new CityEntity();
        cityEntity1.setCityName("Aosta");
        cityService.createCity(cityEntity1);
        CityEntity cityEntity2 = new CityEntity();
        cityEntity2.setCityName("Lausanne");
        cityService.createCity(cityEntity2);
        CityEntity cityEntity3 = new CityEntity();
        cityEntity3.setCityName("Torino");
        cityService.createCity(cityEntity3);

        UserEntity user1 = new UserEntity();
        user1.setTelephone("0762124321");
        user1.setEmail("publicpierre1@gmail.com");
        user1.setName("Pierluigi Vernetto1");
        user1.setPicture("https://lh3.googleusercontent.com/a/ACg8ocJUs8eXkYihHmMNwh2MvWHAMOGdIKiuzQnXpZOvcFsVVRo=s96-c");
        userService.createUser(user1);
        UserEntity user2 = new UserEntity();
        user2.setTelephone("333456789");
        user2.setEmail("vernettop1@gmail.com");
        user2.setName("Igiulreip Ottenrev1");
        user2.setPicture("https://as2.ftcdn.net/v2/jpg/01/17/35/17/1000_F_117351782_ugRMzKUg8pz8ucKVqIPI1JzQSCItC0Hx.jpg");
        userService.createUser(user2);

        RideEntryEntity rideEntry1 = new RideEntryEntity();
        rideEntry1.setRideDate(new Date());
        rideEntry1.setRideTime("05");
        rideEntry1.setRideType(RideType.I_AM_PASSENGER);
        rideEntry1.setFromCity(cityEntity1);
        rideEntry1.setToCity(cityEntity2);
        rideEntry1.setUserEntity(user1);
        rideEntryRepository.save(rideEntry1);

        RideEntryEntity rideEntry2 = new RideEntryEntity();
        rideEntry2.setRideDate(new Date());
        rideEntry2.setRideTime("07");
        rideEntry2.setRideType(RideType.I_AM_DRIVER);
        rideEntry2.setFromCity(cityEntity3);
        rideEntry2.setToCity(cityEntity1);
        rideEntry2.setUserEntity(user2);
        rideEntryRepository.save(rideEntry2);
    }
}
