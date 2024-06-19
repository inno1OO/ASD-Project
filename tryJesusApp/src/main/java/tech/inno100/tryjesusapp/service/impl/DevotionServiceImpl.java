package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.DevotionDto;
import tech.inno100.tryjesusapp.model.Devotion;
import tech.inno100.tryjesusapp.repository.DevotionRepository;
import tech.inno100.tryjesusapp.service.DevotionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevotionServiceImpl implements DevotionService {
    private final DevotionRepository devotionRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<DevotionDto> addDevotion(DevotionDto devotion) {
        return Optional.empty();
    }

    @Override
    public Optional<DevotionDto> getDevotion(Long id){
        return Optional.empty();
    }

    @Override
    public Optional<DevotionDto> updateDevotion(Long id, DevotionDto devotion) {
        return Optional.empty();
    }

    @Override
    public Optional<DevotionDto> deleteDevotion(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DevotionDto> getDevotionByMemberId(Long memberId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<DevotionDto>> getAllDevotions() {
        return Optional.empty();
    }

}
