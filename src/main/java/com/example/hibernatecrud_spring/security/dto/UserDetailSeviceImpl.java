package com.example.hibernatecrud_spring.security.dto;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailServiceImpl")
public class UserDetailSeviceImpl implements UserDetailsService {
    private final UserRepository repository;
    @Autowired
    public UserDetailSeviceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return SecurityUser.fromUser(user);
    }
}
