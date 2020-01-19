package com.hackerrank.github.service.event;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.EventFilter;
import com.hackerrank.github.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * EventService implementation to act as a facade of Events in the system
 *
 */
@Service
public class EventServiceImplementation extends AbstractService implements EventService {

    public List<Event> getEvents(EventFilter eventFilter) {
        return new ArrayList<>();
    }

    public Boolean deleteEvent(Event eventFilter) {
        return true;
    }

    public Event createEvent(Event event) {
        return new Event();
    }

}
