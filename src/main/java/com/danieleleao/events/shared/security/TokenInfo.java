package com.danieleleao.events.shared.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class TokenInfo {
   private String subject;
   private Date expiresIn;
}
