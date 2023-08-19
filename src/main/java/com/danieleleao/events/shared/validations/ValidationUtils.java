package com.danieleleao.events.shared.validations;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean validateEmail(String email) {
        // REGEX Expressões regulares
        String patternEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@"
                + "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        return Pattern.compile(patternEmail).matcher(email).matches();
    }
}
