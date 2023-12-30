package org.pierre.shareazade.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@AllArgsConstructor
@Slf4j
@Controller
public class RideController {

    @GetMapping("/addRide")
    public String addRide() {
        return "addRide";
    }


}
