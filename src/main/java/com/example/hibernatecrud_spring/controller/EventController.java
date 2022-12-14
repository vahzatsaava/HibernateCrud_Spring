package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@Slf4j
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/{id}")
    public Event find(@PathVariable Integer id) {
        return eventService.getOneEvent(id);
    }
    @GetMapping()
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping
    public Event update(@RequestBody Event event) {
        return eventService.update(event);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        eventService.deleteEvent(id);
        log.info("User was deleted ");
    }

}
