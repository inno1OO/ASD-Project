package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.EventDto;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<EventDto> addEvent(EventDto eventDto);
    Optional<EventDto> updateEvent(Long id, EventDto eventDto);
    Optional<EventDto> deleteEvent(Long id);
    Optional<EventDto> getEventById(Long id);
    Optional <List<EventDto>> getAllEvents();
}
