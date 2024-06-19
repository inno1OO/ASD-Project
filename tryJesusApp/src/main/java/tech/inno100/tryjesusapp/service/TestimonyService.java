package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.TestimonyDto;

import java.util.List;
import java.util.Optional;

public interface TestimonyService {
    Optional<TestimonyDto> addTestimony(TestimonyDto testimonyDto);
    Optional<TestimonyDto> updateTestimony(Long testimonyId, TestimonyDto testimonyDto);
    Optional<TestimonyDto> deleteTestimony(Long testimonyId);
    Optional<TestimonyDto> getTestimony(Long testimonyId);
    Optional<List<TestimonyDto>> getAllTestimonys();
    Optional<List<TestimonyDto>> getAllTestimonysByMemberId(Long testimonyId);
}
