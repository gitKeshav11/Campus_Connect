package com.example.College_Event_Management.Service;

import com.example.College_Event_Management.Model.Event;
import com.example.College_Event_Management.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event organizeEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEventById(Long Id, Event event) throws Exception {
        Event existingEvent = eventRepository.findById(Id).orElseThrow(() -> new Exception("Organized Event Not Found...!"));

        existingEvent.setName(event.getName());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setDate(event.getDate());
        existingEvent.setLocation(event.getLocation());

        return eventRepository.save(existingEvent);
    }

    public void cancelEventById(Long Id) throws Exception {
            eventRepository.deleteById(Id);
    }

    public Optional<Event> getEventId(Long id) {
        return eventRepository.findById(id);
    }
}
