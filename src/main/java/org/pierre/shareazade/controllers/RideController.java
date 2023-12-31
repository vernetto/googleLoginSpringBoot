package org.pierre.shareazade.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.constants.Constants;
import org.pierre.shareazade.constants.RideType;
import org.pierre.shareazade.entities.CityEntity;
import org.pierre.shareazade.entities.RideEntryEntity;
import org.pierre.shareazade.services.CityService;
import org.pierre.shareazade.services.RideEntryService;
import org.pierre.shareazade.services.UserService;
import org.pierre.shareazade.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@AllArgsConstructor
@Slf4j
@Controller
public class RideController {
    final CityService cityService;
    final RideEntryService rideEntryService;
    final UserService userService;

    @GetMapping("/addRide")
    public String addRide(Model model) {
        RideEntryEntity rideEntryEntity = new RideEntryEntity();
        rideEntryEntity.setRideType(RideType.I_AM_PASSENGER);
        model.addAttribute("ride", rideEntryEntity);
        CityEntity defaultFrom = cityService.getCityByName(Constants.AOSTA);
        rideEntryEntity.setFromCity(defaultFrom);
        CityEntity defaultTo = cityService.getCityByName(Constants.LAUSANNE);
        rideEntryEntity.setToCity(defaultTo);
        rideEntryEntity.setRideDate(DateUtils.getTomorrowDate());
        rideEntryEntity.setRideTime("09:00");
        rideEntryEntity.setRideComment("");
        model.addAttribute("cities", cityService.findAll());
        return "addRide";
    }

    @PostMapping("/addRidePost")
    public ModelAndView addRide(@ModelAttribute RideEntryEntity rideEntryEntity) {
        rideEntryEntity.setUserEntity(userService.getCurrentUser());
        rideEntryService.createRide(rideEntryEntity);
        return new ModelAndView("redirect:/"); // or another appropriate view
    }

    @GetMapping("/showRideDetails")
    public String showRideDetails(@RequestParam("id") Long rideId, Model model) {
        RideEntryEntity rideEntryEntity = rideEntryService.findById(rideId).get();
        model.addAttribute("ride", rideEntryEntity);
        return "showRideDetails";
    }
}
