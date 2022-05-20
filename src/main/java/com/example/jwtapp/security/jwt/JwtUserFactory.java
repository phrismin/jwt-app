package com.example.jwtapp.security.jwt;

import com.example.jwtapp.model.Role;
import com.example.jwtapp.model.Status;
import com.example.jwtapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser.JwtUserBuilder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(mapToGrantedAuthorities(new ArrayList<>(user.getRoles())))
                .enabled(user.getStatus().equals(Status.ACTIVE))
                .lastPasswordResetDate(user.getUpdatedDate())
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roleList) {
        return roleList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .map(simpleGrantedAuthority -> (GrantedAuthority) simpleGrantedAuthority)
                .toList();
    }
}
