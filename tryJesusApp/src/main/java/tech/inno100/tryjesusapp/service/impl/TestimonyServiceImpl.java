package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.*;
import tech.inno100.tryjesusapp.model.*;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.repository.TestimonyRepository;
import tech.inno100.tryjesusapp.service.TestimonyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestimonyServiceImpl implements TestimonyService {

    private final TestimonyRepository testimonyRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<TestimonyDto> addTestimony(Long id, TestimonyDto testimonyDto){
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member not found");
        }
        Testimony testimony = modelMapper.map(testimonyDto, Testimony.class);
        testimony.setMember(member.get());
        Testimony savedTestimony = testimonyRepository.save(testimony);
        TestimonyDto testimonyDto1 = modelMapper.map(savedTestimony, TestimonyDto.class);
        return Optional.of(testimonyDto1);
    }

    @Override
    public Optional<TestimonyDto> updateTestimony(Long testimonyId, TestimonyDto testimonyDto){
        Optional<Testimony> found = testimonyRepository.findById(testimonyId);
        if (found.isPresent()) {
            modelMapper.map(testimonyDto, found.get());
            Testimony saved = testimonyRepository.save(found.get());
            TestimonyDto testimonyDto1 = modelMapper.map(saved, TestimonyDto.class);
            return Optional.of(testimonyDto1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<TestimonyDto> deleteTestimony(Long testimonyId){
        Optional<Testimony> found = testimonyRepository.findById(testimonyId);
        if (found.isPresent()) {
            testimonyRepository.delete(found.get());
            TestimonyDto testimonyDto = modelMapper.map(found.get(), TestimonyDto.class);
            return Optional.of(testimonyDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<TestimonyDto> getTestimony(Long testimonyId){
        Optional<Testimony> found = testimonyRepository.findById(testimonyId);
        if (found.isPresent()) {
            TestimonyDto testimonyDto = modelMapper.map(found.get(), TestimonyDto.class);
            return Optional.of(testimonyDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<TestimonyDto>> getAllTestimonys(){
        List<Testimony> testimonies = testimonyRepository.findAll();
        if (testimonies.isEmpty()) {
            return Optional.empty();
        }
        List<TestimonyDto> testimonyDtos = modelMapper.map(testimonies, new TypeToken<List<TestimonyDto>>() {}.getType());
        return Optional.of(testimonyDtos);
    }

    @Override
    public Optional<List<TestimonyDto>> getAllTestimonysByMemberId(Long testimonyId){
        Optional<List<Testimony>> found = testimonyRepository.findByMemberId(testimonyId);
        if (found.isPresent()) {
            List<TestimonyDto> testimonyDtos = found.get().stream()
                    .map(testimony -> modelMapper.map(testimony, TestimonyDto.class))
                    .collect(Collectors.toList());
            return Optional.of(testimonyDtos);
        }
        return Optional.empty();
    }
}
