package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.*;
import tech.inno100.tryjesusapp.model.*;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.repository.PrayerRequestRepository;
import tech.inno100.tryjesusapp.service.PrayerRequestService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrayerRequestServiceImpl implements PrayerRequestService {

    private final PrayerRequestRepository prayerRequestRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<PrayerRequestDto> addPrayerRequest(Long id, PrayerRequestDto prayerRequestDto){
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member not found");
        }
        PrayerRequest prayerRequest = modelMapper.map(prayerRequestDto, PrayerRequest.class);
        prayerRequest.setMember(member.get());
        PrayerRequest savedPrayer = prayerRequestRepository.save(prayerRequest);
        PrayerRequestDto prayerRequestDto1 = modelMapper.map(savedPrayer, PrayerRequestDto.class);
        return Optional.of(prayerRequestDto1);
    }
    @Override
    public Optional<PrayerRequestDto> getPrayerRequestById(Long id){
        Optional<PrayerRequest> found = prayerRequestRepository.findById(id);
        if (found.isPresent()) {
            PrayerRequestDto prayerRequestDto = modelMapper.map(found.get(), PrayerRequestDto.class);
            return Optional.of(prayerRequestDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<PrayerRequestDto> updatePrayerRequest(Long id, PrayerRequestDto prayerRequestDto){
        Optional<PrayerRequest> found = prayerRequestRepository.findById(id);
        if (found.isPresent()) {
            modelMapper.map(prayerRequestDto, found.get());
            PrayerRequest saved = prayerRequestRepository.save(found.get());
            PrayerRequestDto prayerRequestDto1 = modelMapper.map(saved, PrayerRequestDto.class);
            return Optional.of(prayerRequestDto1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<PrayerRequestDto>> getAllPrayerRequests(){
        List<PrayerRequest> prayers = prayerRequestRepository.findAll();
        if (prayers.isEmpty()) {
            return Optional.empty();
        }
        List<PrayerRequestDto> prayerDto = modelMapper.map(prayers, new TypeToken<List<PrayerRequestDto>>() {}.getType());
        return Optional.of(prayerDto);
    }

    @Override
    public Optional<PrayerRequestDto> deletePrayerRequestById(Long id){
        Optional<PrayerRequest> found = prayerRequestRepository.findById(id);
        if (found.isPresent()) {
            prayerRequestRepository.delete(found.get());
            PrayerRequestDto prayerRequestDto = modelMapper.map(found.get(), PrayerRequestDto.class);
            return Optional.of(prayerRequestDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<PrayerRequestDto>> getAllPrayerRequestsByMemberId(Long userId){
        Optional<List<PrayerRequest>> found = prayerRequestRepository.findByMemberId(userId);
        if (found.isPresent()) {
            List<PrayerRequestDto> prayerRequestDtos = found.get().stream()
                    .map(prayer -> modelMapper.map(prayer, PrayerRequestDto.class))
                    .collect(Collectors.toList());
            return Optional.of(prayerRequestDtos);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<PrayerRequestDto>> getAllPrayerRequestsByCategory(String category){
        return Optional.empty();
    }
}
