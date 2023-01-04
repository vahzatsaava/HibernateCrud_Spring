package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public Event find(@PathVariable Long id) {
        return eventService.getOneEvent(id);
    }
    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Event create(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public Event update(@RequestBody Event event) {
        return eventService.update(event);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public void delete(@PathVariable Long id){
        eventService.deleteEvent(id);
        log.info("User was deleted ");
    }

}
