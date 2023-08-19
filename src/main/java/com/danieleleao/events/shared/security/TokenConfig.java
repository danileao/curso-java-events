package com.danieleleao.events.shared.security;

import com.danieleleao.events.modules.customers.dto.JWTToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Collections;

public class TokenConfig {
    private static final String SECRET_KEY = "AppEventsSpringBootAppEventsSpringBoot";


    public static JWTToken encode(TokenInfo tokenInfo) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String jwt = Jwts.builder()
                .setSubject(tokenInfo.getSubject())
                .setIssuer("EVENTS_APP")
                .setExpiration(tokenInfo.getExpiresIn())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return new JWTToken("Bearer " + jwt);
    }

    public static Authentication decode(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        token = token.replace("Bearer", "");

        Jws<Claims> claims = Jwts
                .parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build().parseClaimsJws(token);

        String subject = claims.getBody().getSubject();

        return new UsernamePasswordAuthenticationToken(subject, null, Collections.emptyList());
    }
}
