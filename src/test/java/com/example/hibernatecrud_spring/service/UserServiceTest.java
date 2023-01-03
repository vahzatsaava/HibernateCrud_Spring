package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.Status;
import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import com.example.hibernatecrud_spring.repository.hibernate.HibernateUserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private final User user = new User("garry", "charly@", "one", "two", "2203", Status.ACTIVE);

    @Test
    void save_Successful() {
        when(userRepository.add(any(User.class))).thenReturn(user);
        assertEquals(userService.save(user).getUserName(), "garry");
    }

    @Test
    void save_UnSuccessful() {
        when(userRepository.add(any(User.class))).thenReturn(user);
        assertNotEquals(userService.save(user).getUserName(), null);
    }

    @Test
    void update_Successful() {
        when(userRepository.update(any(User.class))).thenReturn(user);
        assertEquals(userService.update(user).getUserName(), "garry");
    }

    @Test
    void update_UnSuccessful() {
        when(userRepository.update(any(User.class))).thenReturn(user);
        assertNotEquals(userService.update(user).getUserName(), null);
    }

    @Test
    void getOneUser_Successful() {
        when(userRepository.find(10L)).thenReturn(user);
        assertEquals(userService.getOneUser(10L).getUserName(), "garry");
    }
    @Test
    void getOneUser_UnSuccessful() {
        when(userRepository.find(10L)).thenReturn(user);
        assertNotEquals(userService.getOneUser(10L).getUserName(), null);
    }

    @Test
    void getAllUsers_Successful() {
        when(userRepository.getAll()).thenReturn(List.of(user));
        assertEquals(userService.getAllUsers(), List.of(user));
    }

    @Test
    void getAllUsers_UnSuccessful() {
        when(userRepository.getAll()).thenReturn(List.of(user));
        assertNotEquals(userService.getAllUsers(), null);
    }

    @Test
    void findByUserName_Successful() {
        when(userRepository.findByUserName(anyString())).thenReturn(user);
        assertEquals(userService.findByUserName("garry").getUserName(), "garry");
    }

    @Test
    void findByUserName_UnSuccessful() {
        when(userRepository.findByUserName(anyString())).thenReturn(user);
        assertNotEquals(userService.findByUserName("garry").getUserName(), null);
    }
}