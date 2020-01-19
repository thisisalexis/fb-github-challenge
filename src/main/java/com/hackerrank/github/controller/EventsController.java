package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Boolean> erase() {
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return ResponseEntity.ok(new Event());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
        return ResponseEntity.ok(new Event());
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents(@RequestParam(value = "repository-id", required = false) Long repositoryId,
                                                 @RequestParam(value = "actor-id", required = false) Long actorId) {


        return ResponseEntity.ok(new ArrayList());
    }




}
