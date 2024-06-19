package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.PrayerRequestDto;

import java.util.List;
import java.util.Optional;

public interface PrayerRequestService {
    Optional<PrayerRequestDto> addPrayerRequest(PrayerRequestDto prayerRequestDto);
    Optional<PrayerRequestDto> getPrayerRequestById(Long id);
    Optional<List<PrayerRequestDto>> getAllPrayerRequests();
    Optional<PrayerRequestDto> deletePrayerRequestById(Long id);
    Optional<List<PrayerRequestDto>> getAllPrayerRequestsByMemberId(Long userId);
    Optional<List<PrayerRequestDto>> getAllPrayerRequestsByCategory(Long id);
}
