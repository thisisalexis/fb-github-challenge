package com.hackerrank.github.service.event;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.EventFilter;

import java.util.List;

public interface EventService {

    List<Event> getEvents(EventFilter eventFilter);

    Boolean deleteEvent(Event eventFilter);

    Event createEvent(Event event);

}
