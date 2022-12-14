package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getOneEvent(Integer id) {
        return eventRepository.find(id);
    }

    public Event save(Event event) {
        return eventRepository.add(event);
    }

    public Event update(Event event) {
        return eventRepository.update(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAll();
    }

    public void deleteEvent(Integer id) {
        eventRepository.delete(id);
    }
}
