package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.TestimonyDto;
import tech.inno100.tryjesusapp.repository.TestimonyRepository;
import tech.inno100.tryjesusapp.service.TestimonyService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestimonyServiceImpl implements TestimonyService {

    private final TestimonyRepository testimonyRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<TestimonyDto> addTestimony(TestimonyDto testimonyDto){
        return Optional.empty();
    }

    @Override
    public Optional<TestimonyDto> updateTestimony(Long testimonyId, TestimonyDto testimonyDto){
        return Optional.empty();
    }

    @Override
    public Optional<TestimonyDto> deleteTestimony(Long testimonyId){
        return Optional.empty();
    }

    @Override
    public Optional<TestimonyDto> getTestimony(Long testimonyId){
        return Optional.empty();
    }

    @Override
    public Optional<List<TestimonyDto>> getAllTestimonys(){
        return Optional.empty();
    }

    @Override
    public Optional<List<TestimonyDto>> getAllTestimonysByMemberId(Long testimonyId){
        return Optional.empty();
    }
}
