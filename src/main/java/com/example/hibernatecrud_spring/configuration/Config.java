package com.example.hibernatecrud_spring.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class Config {

    @Bean
    @Qualifier("ENCODER")
    public PasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }


}
