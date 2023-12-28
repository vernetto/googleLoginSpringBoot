package com.example.googleloginspringboot;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
public class WebController {


    @GetMapping("/")
    public String index(Model model, OAuth2AuthenticationToken authentication) {
        if (authentication != null) {
            OAuth2User oAuth2User = authentication.getPrincipal();
            model.addAttribute("user", oAuth2User.getAttributes());
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

}

