package com.example.jwtapp.security.jwt;

import com.example.jwtapp.model.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long validityInMilliseconds;

    public String createToken(String username, List<Role> role) {
        return username;
    }

    public Authentication getAuthentication(String token) {
        return null;
    }

    public String getUsername(Object token) {
        return null;
    }

    public boolean validateToken(String token) {
        return true;
    }

    private List<String> getRoleNames(List<Role> userRoles) {
        List<String> rolesList = new ArrayList<>();
        userRoles.forEach(role -> rolesList.add(role.getName()));
        return rolesList;
    }
}
