package com.danieleleao.events.shared.entities;

import com.danieleleao.events.shared.exceptions.CustomException;
import com.danieleleao.events.shared.security.PasswordUtils;
import com.danieleleao.events.shared.validations.ValidationUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntityUser {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String email;
    private String password; //1234
    public void setEmail(String email) {
        if(!ValidationUtils.validateEmail(email)) {
            throw  new CustomException("Email is invalid", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = PasswordUtils.encode(password);
    }
}
