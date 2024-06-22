package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<EventDto> addEvent(@PathVariable("id") Long id, @RequestBody EventDto eventDto){
        Optional<EventDto> eventDtoOptional = eventService.addEvent(id, eventDto);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/event/{id}")
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long id, @RequestBody EventDto eventDto){
        Optional<EventDto> eventDtoOptional = eventService.updateEvent(id, eventDto);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("event/{id}")
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable("id") Long id){
        Optional<EventDto> eventDtoOptional = eventService.deleteEvent(id);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
         return ResponseEntity.notFound().build();
    }

    @GetMapping("/event/{id}")
    @PreAuthorize("hasAnyAuthority('member:read', 'member:write', 'admin:write', 'admin:read')")
    public ResponseEntity<EventDto> getEventById(@PathVariable("id") Long id){
        Optional<EventDto> eventDtoOptional = eventService.getEventById(id);
        if(eventDtoOptional.isPresent()){
            return ResponseEntity.ok(eventDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('member:read', 'member:write', 'admin:write', 'admin:read')")
    public ResponseEntity<List<EventDto>> getAllEvents(){
        Optional<List<EventDto>> events = eventService.getAllEvents();
        if(events.isPresent()){
            return ResponseEntity.ok(events.get());
        }
        return ResponseEntity.notFound().build();
    }
}
