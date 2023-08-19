package com.danieleleao.events.shared.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");
        SecurityContextHolder.getContext().setAuthentication(null);

        if(headerToken != null) {
            // Decode do token
            Authentication auth = TokenConfig.decode(request);
            if(auth != null) {
                SecurityContextHolder.getContext().setAuthentication(auth);
            }else {
                response.setStatus(401);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
