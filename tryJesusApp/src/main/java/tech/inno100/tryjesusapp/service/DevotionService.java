package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.DevotionDto;

import java.util.List;
import java.util.Optional;

public interface DevotionService {
    Optional<DevotionDto> addDevotion(DevotionDto devotionDto);
    Optional<DevotionDto> getDevotion(Long id);
    Optional<DevotionDto> updateDevotion(Long id, DevotionDto devotionDto);
    Optional<DevotionDto> deleteDevotion(Long id);
    Optional<DevotionDto> getDevotionByMemberId(Long memberId);
    Optional<List<DevotionDto>> getAllDevotions();
}
