package org.pierre.shareazade.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.converters.EntityDTOConverter;
import org.pierre.shareazade.dtos.RideEntryDTO;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.services.RideEntryService;
import org.pierre.shareazade.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@Slf4j
@Controller
public class LoginController {
    private final RideEntryService rideEntryService;
    private final EntityDTOConverter entityDTOConverter;
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        Authentication authenticationFromContext = SecurityContextHolder.getContext().getAuthentication();
        if (authenticationFromContext != null && authenticationFromContext.getPrincipal() instanceof OAuth2User) {
            OAuth2User oAuth2User = (OAuth2User) authenticationFromContext.getPrincipal();
            log.info("user from context " + oAuth2User.getAttributes());
            UserEntity userEntity = userService.createNewUserWhenNeeded(oAuth2User);
            model.addAttribute("user", userEntity);
        }
        addRides(model);
        return "index";
    }

    private void addRides(Model model) {
        List<RideEntryDTO> rides = entityDTOConverter.convertRideEntryEntityToDTOList(rideEntryService.findAll());
        model.addAttribute("rides", rides);
    }

}
