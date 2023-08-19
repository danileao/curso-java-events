package com.danieleleao.events.shared.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {


    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
       return  new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }

}
