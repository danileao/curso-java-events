package com.danieleleao.events.shared.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/customers/").permitAll()
                .antMatchers(HttpMethod.POST, "/customers/login").permitAll()
                .antMatchers(HttpMethod.POST, "/organizers/").permitAll()
                                .antMatchers(HttpMethod.POST, "/events/").permitAll()

                .anyRequest().authenticated()
                .and().addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class )
        ;


        return http.build();
    }
}
