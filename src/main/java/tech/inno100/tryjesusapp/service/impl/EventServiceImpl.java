package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.AddressDto;
import tech.inno100.tryjesusapp.dto.DevotionDto;
import tech.inno100.tryjesusapp.dto.EventDto;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.model.Address;
import tech.inno100.tryjesusapp.model.Devotion;
import tech.inno100.tryjesusapp.model.Event;
import tech.inno100.tryjesusapp.model.Member;
import tech.inno100.tryjesusapp.repository.EventRepository;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<EventDto> addEvent(Long id, EventDto eventDto){
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member not found");
        }
        Event event = modelMapper.map(eventDto, Event.class);
        event.setMember(member.get());
        Event savedEvent = eventRepository.save(event);
        EventDto eventDto1 = modelMapper.map(savedEvent, EventDto.class);
        return Optional.of(eventDto1);
    }

    @Override
    public Optional<EventDto> updateEvent(Long id, EventDto eventDto){
        Optional<Event> found = eventRepository.findById(id);
        if (found.isPresent()) {
            modelMapper.map(eventDto, found.get());
            Event saved = eventRepository.save(found.get());
            EventDto eventDto1 = modelMapper.map(saved, EventDto.class);
            return Optional.of(eventDto1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<EventDto> deleteEvent(Long id){
        Optional<Event> found = eventRepository.findById(id);
        if (found.isPresent()) {
            eventRepository.delete(found.get());
            EventDto eventDto = modelMapper.map(found.get(), EventDto.class);
            return Optional.of(eventDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<EventDto> getEventById(Long id){
        Optional<Event> found = eventRepository.findById(id);
        if (found.isPresent()) {
            EventDto eventDto = modelMapper.map(found.get(), EventDto.class);
            return Optional.of(eventDto);
        }
        return Optional.empty();
    }
    @Override
    public Optional <List<EventDto>> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) {
            return Optional.empty();
        }
        List<EventDto> eventDtos = modelMapper.map(events, new TypeToken<List<EventDto>>() {}.getType());
        return Optional.of(eventDtos);
    }
}
