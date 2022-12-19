package com.example.hibernatecrud_spring.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.USER_UPDATE, Permission.USER_WRITE, Permission.USER_READ)),
    MODERATOR(Set.of(Permission.USER_UPDATE, Permission.USER_WRITE, Permission.USER_READ, Permission.MODERATOR_DELETE, Permission.MODERATOR_UPDATE
            , Permission.MODERATOR_WRITE, Permission.MODERATOR_READ_ALL_USERS, Permission.MODERATOR_READ)),
    ADMIN(Set.of(Permission.USER_UPDATE, Permission.USER_WRITE, Permission.USER_READ, Permission.MODERATOR_DELETE, Permission.MODERATOR_UPDATE
            , Permission.MODERATOR_WRITE, Permission.MODERATOR_READ_ALL_USERS, Permission.MODERATOR_READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}


