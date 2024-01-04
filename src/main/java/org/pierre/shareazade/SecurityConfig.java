package org.pierre.shareazade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)



public class SecurityConfig  {
    //@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        MvcRequestMatcher allPathsMatcher = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/**");
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(allPathsMatcher)
                        .authenticated()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")).disable());;
        return http.build();
    }

    public SecurityFilterChain filterChainBAD(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**", "/actuator/**")).
                        permitAll().
                        anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions().disable())

                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")).disable());;
        return http.build();
    }

}
