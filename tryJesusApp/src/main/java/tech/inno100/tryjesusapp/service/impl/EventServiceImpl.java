package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.EventDto;
import tech.inno100.tryjesusapp.repository.EventRepository;
import tech.inno100.tryjesusapp.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<EventDto> addEvent(EventDto eventDto){
        return Optional.of(eventDto);
    }

    @Override
    public Optional<EventDto> updateEvent(Long id, EventDto eventDto){
        return Optional.of(eventDto);
    }

    @Override
    public Optional<EventDto> deleteEvent(Long id){
        return Optional.empty();
    }

    @Override
    public Optional<EventDto> getEventById(Long id){
        return Optional.empty();
    }
    @Override
    public Optional <List<EventDto>> getAllEvents(){
        return Optional.empty();
    }
}
