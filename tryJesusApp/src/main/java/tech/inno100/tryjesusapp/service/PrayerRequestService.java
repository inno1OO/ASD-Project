package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.PrayerRequestDto;

import java.util.List;
import java.util.Optional;

public interface PrayerRequestService {
    Optional<PrayerRequestDto> addPrayerRequest(Long id, PrayerRequestDto prayerRequestDto);
    Optional<PrayerRequestDto> getPrayerRequestById(Long id);
    Optional<List<PrayerRequestDto>> getAllPrayerRequests();
    Optional<PrayerRequestDto> deletePrayerRequestById(Long id);
    Optional<List<PrayerRequestDto>> getAllPrayerRequestsByMemberId(Long userId);
    Optional<List<PrayerRequestDto>> getAllPrayerRequestsByCategory(String category);
    Optional<PrayerRequestDto> updatePrayerRequest(Long id, PrayerRequestDto prayerRequestDto);
}
