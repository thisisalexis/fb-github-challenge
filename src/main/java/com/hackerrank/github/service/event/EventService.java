package com.hackerrank.github.service.event;

import com.hackerrank.github.exception.event.EventExistsException;
import com.hackerrank.github.exception.event.EventNotFoundException;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.EventFilter;

import java.util.List;

public interface EventService {

    List<Event> getEvents(EventFilter eventFilter) throws EventNotFoundException;

    Event getEventById(Long eventId) throws EventNotFoundException;

    void deleteAllEvents();

    Event createEvent(Event event) throws EventExistsException;

}
