package com.danieleleao.events.modules.customers.controllers;


import com.danieleleao.events.modules.customers.dto.JWTToken;
import com.danieleleao.events.modules.customers.dto.LoginDTO;
import com.danieleleao.events.modules.customers.entities.Customer;
import com.danieleleao.events.modules.customers.repository.ICustomerRepository;
import com.danieleleao.events.shared.exceptions.CustomException;
import com.danieleleao.events.shared.security.PasswordUtils;
import com.danieleleao.events.shared.security.TokenConfig;
import com.danieleleao.events.shared.security.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/customers")
public class LoginCustomerController {

    @Autowired
    private ICustomerRepository customerRepository;


    @PostMapping("/login")
    public JWTToken login(@RequestBody LoginDTO loginDTO) {
        // Verificar se email existe no customer
        var customerExists = this.customerRepository.findByEmail(loginDTO.getEmail());

        if(customerExists == null) {
            throw  new CustomException("Email/password incorrect", HttpStatus.UNAUTHORIZED);
        }
        // Verificar a senha

        //dani@123
        // $2a$10$edBs716IS8wOG9Y.h/l7IOYDdHVShig092n9nk8o3sSEgiSVi4cDG
        // $2a$10$8Yt62I3E9Unr8DkCiN47aOwG1IPuNzHFXdo.TNjefyiFAhP9DclXC
        var passwordEquals = PasswordUtils.matches(loginDTO.getPassword(), customerExists.getPassword());

        if(!passwordEquals) {
            throw  new CustomException("Email/password incorrect", HttpStatus.UNAUTHORIZED);
        }

        // Gerar o token
        var SECONDS = 1000;
        var MINUTES = 60 * SECONDS;
        var expiresIn = new Date(System.currentTimeMillis() + MINUTES);
        var token = TokenConfig.encode(new TokenInfo(loginDTO.getEmail(), expiresIn ));

        return token;
    }
}
