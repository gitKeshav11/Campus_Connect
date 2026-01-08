package com.example.College_Event_Management.Controller;

import com.example.College_Event_Management.Model.Event;
import com.example.College_Event_Management.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/all-events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/event/{Id}")
    public Optional<Event> getEventId(@PathVariable Long Id) throws Exception {
        return eventService.getEventId(Id);
    }

    @PostMapping("/organize")// dont give id when posting JSON data on postman
    public Event organizeEvent(@RequestBody Event event){
        return eventService.organizeEvent(event);
    }

    @PutMapping("/update/{Id}")
    public Event updateEventById(@PathVariable Long Id, @RequestBody Event event) throws Exception {
        return eventService.updateEventById(Id,event);
    }

    @DeleteMapping("/cancelEvent/{Id}")
    public void cancelEventById(@PathVariable Long Id) throws Exception {
        eventService.cancelEventById(Id);
    }
}
