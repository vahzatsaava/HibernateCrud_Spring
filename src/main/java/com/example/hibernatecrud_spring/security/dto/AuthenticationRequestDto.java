package com.example.hibernatecrud_spring.security.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;

}
