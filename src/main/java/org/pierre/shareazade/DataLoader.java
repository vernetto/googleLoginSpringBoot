package org.pierre.shareazade;

import lombok.AllArgsConstructor;
import org.pierre.shareazade.constants.RideType;
import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.entities.RideEntryEntity;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.repositories.CityRepository;
import org.pierre.shareazade.repositories.RideEntryRepository;
import org.pierre.shareazade.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {
    private final RideEntryRepository rideEntryRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;

    public void run(ApplicationArguments args) {
        CityEntity cityEntity1 = new CityEntity();
        cityEntity1.setCityName("Aosta");
        cityRepository.save(cityEntity1);
        CityEntity cityEntity2 = new CityEntity();
        cityEntity2.setCityName("Lausanne");
        cityRepository.save(cityEntity2);
        CityEntity cityEntity3 = new CityEntity();
        cityEntity3.setCityName("Torino");
        cityRepository.save(cityEntity3);

        UserEntity user1 = new UserEntity();
        user1.setTelephone("0762124321");
        user1.setEmail("publicpierre@gmail.com");
        user1.setFullName("Pierluigi Vernetto");
        userRepository.save(user1);
        UserEntity user2 = new UserEntity();
        user2.setTelephone("333456789");
        user2.setEmail("vernettop@gmail.com");
        user2.setFullName("Igiulreip Ottenrev");
        userRepository.save(user2);

        RideEntryEntity rideEntry1 = new RideEntryEntity();
        rideEntry1.setRideDate(new Date());
        rideEntry1.setRideTime("05");
        rideEntry1.setRideType(RideType.REQUEST);
        rideEntry1.setFromCity(cityEntity1);
        rideEntry1.setToCity(cityEntity2);
        rideEntry1.setUserEntity(user1);
        rideEntryRepository.save(rideEntry1);

        RideEntryEntity rideEntry2 = new RideEntryEntity();
        rideEntry2.setRideDate(new Date());
        rideEntry2.setRideTime("07");
        rideEntry2.setRideType(RideType.OFFER);
        rideEntry2.setFromCity(cityEntity3);
        rideEntry2.setToCity(cityEntity1);
        rideEntry2.setUserEntity(user2);
        rideEntryRepository.save(rideEntry2);
    }
}
