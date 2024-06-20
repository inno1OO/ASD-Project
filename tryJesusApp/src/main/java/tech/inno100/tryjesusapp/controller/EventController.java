package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.EventDto;
import tech.inno100.tryjesusapp.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @PostMapping("/member/{id}")
    public ResponseEntity<EventDto> addEvent(@PathVariable Long id, @RequestBody EventDto eventDto){
        Optional<EventDto> eventDtoOptional = eventService.addEvent(id, eventDto);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long id, @RequestBody EventDto eventDto){
        Optional<EventDto> eventDtoOptional = eventService.updateEvent(id, eventDto);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("event/{id}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable Long id){
        Optional<EventDto> eventDtoOptional = eventService.deleteEvent(id);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
         return ResponseEntity.notFound().build();
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id){
        Optional<EventDto> eventDtoOptional = eventService.getEventById(id);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents(){
        Optional<List<EventDto>> events = eventService.getAllEvents();
        if(events.isPresent()){
            return ResponseEntity.ok(events.get());
        }
        return ResponseEntity.notFound().build();
    }
}
