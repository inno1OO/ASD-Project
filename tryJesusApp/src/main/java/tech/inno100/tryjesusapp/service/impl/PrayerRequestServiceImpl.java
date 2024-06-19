package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.PrayerRequestDto;
import tech.inno100.tryjesusapp.repository.PrayerRequestRepository;
import tech.inno100.tryjesusapp.service.PrayerRequestService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrayerRequestServiceImpl implements PrayerRequestService {

    private final PrayerRequestRepository prayerRequestRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<PrayerRequestDto> addPrayerRequest(PrayerRequestDto prayerRequestDto){
        return Optional.empty();
    }
    @Override
    public Optional<PrayerRequestDto> getPrayerRequestById(Long id){
        return Optional.empty();
    }

    @Override
    public Optional<List<PrayerRequestDto>> getAllPrayerRequests(){
        return Optional.empty();
    }

    @Override
    public Optional<PrayerRequestDto> deletePrayerRequestById(Long id){
        return Optional.empty();
    }

    @Override
    public Optional<List<PrayerRequestDto>> getAllPrayerRequestsByMemberId(Long userId){
        return Optional.empty();
    }

    @Override
    public Optional<List<PrayerRequestDto>> getAllPrayerRequestsByCategory(Long id){
        return Optional.empty();
    }
}
