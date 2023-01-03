package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.model.Status;
import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class EventServiceTest {
    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;

    private final File file = new File("name", "www.file", Status.ACTIVE);
    private final User user = new User("garry", "charly@", "one", "two", "2203", Status.ACTIVE);
    private final Event event = new Event(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), Status.ACTIVE, file, user);

    @Test
    void getOneEvent_Successful() {
        when(eventRepository.find(10L)).thenReturn(event);
        assertEquals(eventService.getOneEvent(10L).getUser().getUserName(),"garry");
    }
    @Test
    void getOneEvent_UnSuccessful() {
        when(eventRepository.find(10L)).thenReturn(event);
        assertNotEquals(eventService.getOneEvent(10L).getUser().getUserName(),"newName");
    }

    @Test
    void save_Successful() {
        when(eventRepository.add(any(Event.class))).thenReturn(event);
        assertEquals(eventService.save(event).getUser().getUserName(),"garry");
    }
    @Test
    void save_UnSuccessful() {
        when(eventRepository.add(any(Event.class))).thenReturn(event);
        assertNotEquals(eventService.save(event).getUser().getUserName(),"garrys");
    }

    @Test
    void update_Successful() {
        when(eventRepository.update(any(Event.class))).thenReturn(event);
        assertEquals(eventService.update(event).getUser().getUserName(),"garry");
    }
    @Test
    void update_UnSuccessful() {
        when(eventRepository.update(any(Event.class))).thenReturn(event);
        assertNotEquals(eventService.update(event).getUser().getUserName(),"newName");
    }

    @Test
    void getAllEvents_Successful() {
        when(eventRepository.getAll()).thenReturn(List.of(event));
        assertEquals(eventService.getAllEvents(),List.of(event));
    }
    @Test
    void getAllEvents_UnSuccessful() {
        when(eventRepository.getAll()).thenReturn(List.of(event));
        assertNotEquals(eventService.getAllEvents(),null);
    }
}