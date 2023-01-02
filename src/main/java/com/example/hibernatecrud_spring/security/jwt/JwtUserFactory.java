package com.example.hibernatecrud_spring.security.jwt;

import com.example.hibernatecrud_spring.model.Role;
import com.example.hibernatecrud_spring.model.Status;
import com.example.hibernatecrud_spring.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(),
                user.getUserName(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrandetAuthority(new ArrayList<>(user.getRoles())));
    }

    private static List<GrantedAuthority> mapToGrandetAuthority(List<Role> userRoles) {
        return userRoles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }
}
