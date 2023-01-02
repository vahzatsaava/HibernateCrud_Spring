package com.example.hibernatecrud_spring.security;

import com.example.hibernatecrud_spring.security.filter.JwttokenFilter;
import com.example.hibernatecrud_spring.security.token.JwtTokenProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenProvider tokenProvider;

    public JwtConfigurer(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        JwttokenFilter jwttokenFilter = new JwttokenFilter(tokenProvider);
        httpSecurity.addFilterBefore(jwttokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
