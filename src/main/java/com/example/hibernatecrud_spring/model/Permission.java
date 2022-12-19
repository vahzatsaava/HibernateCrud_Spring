package com.example.hibernatecrud_spring.model;

public enum Permission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_UPDATE("user:update"),

    MODERATOR_READ("moderator:read"),
    MODERATOR_READ_ALL_USERS("moderator:read_all"),
    MODERATOR_WRITE("moderator:write"),
    MODERATOR_DELETE("moderator:delete"),
    MODERATOR_UPDATE("moderator:update"),

    ADMIN_READ_ALL("admin:read-all");



    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
