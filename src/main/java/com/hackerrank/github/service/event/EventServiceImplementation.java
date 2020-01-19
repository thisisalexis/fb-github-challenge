package com.hackerrank.github.service.event;

import com.hackerrank.github.exception.event.EventExistsException;
import com.hackerrank.github.exception.event.EventNotFoundException;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.EventFilter;
import com.hackerrank.github.repo.EventRepository;
import com.hackerrank.github.service.AbstractService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * EventService implementation to act as a facade of Events in the system
 *
 */
@Service
public class EventServiceImplementation extends AbstractService implements EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImplementation.class);

    @Autowired
    EventRepository eventRepository;

    public List<Event> getEvents(EventFilter eventFilter) throws EventNotFoundException {
        try {
            return new ArrayList<>();
        } catch (Exception e) {
            LOGGER.error("Could not get events", e);
            throw e;
        }
    }

    /**
     * Given an Event ID, it returns stored information about it
     * @param eventId Event id to look for
     * @return found Event
     * @throws EventNotFoundException if event does not exist
     */
    public Event getEventById(Long eventId) throws EventNotFoundException {
        try {
            return eventRepository.getOne(eventId);
        } catch (Exception e) {
            LOGGER.error("There were an exception while trying to get event with id" + eventId, e);
            throw new EventNotFoundException();
        }
    }

    /**
     * Delete all events en the repo
     */
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    /**
     * Adds an event given an Event instance
     * @param event representation of Event object to create
     * @return The just created event
     * @throws EventExistsException if the event id already exists in repo
     */
    public Event createEvent(Event event) throws EventExistsException {
        try {
            return eventRepository.save(event);
        } catch (ConstraintViolationException e) {
            LOGGER.error("ID already exists", e);
            throw new EventExistsException();
        } catch (Exception e) {
            LOGGER.error("Could not delete events", e);
            throw e;
        }
    }

}
