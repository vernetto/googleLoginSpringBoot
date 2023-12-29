package org.pierre.shareazade.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.converters.EntityDTOConverter;
import org.pierre.shareazade.dtos.UserDTO;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {

    // Assuming you have a UserService to handle user data
    private final UserService userService;
    private final EntityDTOConverter entityDTOConverter;



    @GetMapping("/editUser")
    public String showEditForm(@RequestParam("id") Long userId, Model model) {
        log.info("userId: {}", userId);
        // Retrieve the currently authenticated user's details
        // TODO retrieve the current user
        UserEntity userEntity = userService.getCurrentUserDetails();
        model.addAttribute("user", entityDTOConverter.convertUserEntityToDTOs(userEntity));
        return "editUser";
    }

    @PostMapping("/saveUserDetails")
    public String saveUserDetails(@ModelAttribute UserDTO userDTO, Model model) {
        // TODO fail if not same as logged in user
        log.info("userDTO: {}", userDTO);
        userService.updateUserDetails(userDTO);
        return "redirect:/";
    }
}
