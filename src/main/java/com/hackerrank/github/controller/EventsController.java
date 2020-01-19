package com.hackerrank.github.controller;

import com.hackerrank.github.exception.event.EventExistsException;
import com.hackerrank.github.exception.event.EventNotFoundException;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.EventFilter;
import com.hackerrank.github.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/events")
public class EventsController {

    @Autowired
    EventService eventService;

    @DeleteMapping(value = "erase")
    public ResponseEntity<Boolean> deleteAllEvents() {
        try {
            eventService.deleteAllEvents();
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event addEvent) {
        try {
            Event addedEvent = eventService.createEvent(addEvent);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
        } catch (EventExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        try {
            Event event = eventService.getEventById(id);
            return ResponseEntity.status(HttpStatus.OK).body(event);
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/repos/{repoId}")
    public ResponseEntity<List<Event>> getEventsByRepoId(@PathVariable Long repoId) {
        EventFilter eventFilter = new EventFilter();
        eventFilter.setRepoId(repoId);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.getEvents(eventFilter));
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }

    @GetMapping(value = "/actors/{actorId}")
    public ResponseEntity<List<Event>> getEventsByActorId(@PathVariable Long actorId) {
        EventFilter eventFilter = new EventFilter();
        eventFilter.setActorId(actorId);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.getEvents(eventFilter));
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }

    @GetMapping(value = "/repos/{repoId}/actors/{actorId}")
    public ResponseEntity<List<Event>> getEventsByRepoAndActorIds(@PathVariable Long repoId, @PathVariable Long actorId) {
        EventFilter eventFilter = new EventFilter();
        eventFilter.setRepoId(repoId);
        eventFilter.setActorId(actorId);

        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.getEvents(eventFilter));
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }


}
