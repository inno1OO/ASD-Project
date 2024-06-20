package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.DevotionDto;
import tech.inno100.tryjesusapp.model.Devotion;
import tech.inno100.tryjesusapp.model.Member;
import tech.inno100.tryjesusapp.repository.DevotionRepository;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.service.DevotionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DevotionServiceImpl implements DevotionService {
    private final DevotionRepository devotionRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<DevotionDto> addDevotion(Long id, DevotionDto devotionDto) {
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member not found");
        }
        Devotion devotion = modelMapper.map(devotionDto, Devotion.class);
        devotion.setMember(member.get());
        Devotion savedDevotion = devotionRepository.save(devotion);
        DevotionDto devotionDto1 = modelMapper.map(savedDevotion, DevotionDto.class);
        return Optional.of(devotionDto1);
    }

    @Override
    public Optional<DevotionDto> getDevotion(Long id){
        Optional<Devotion> found = devotionRepository.findById(id);
        if (found.isPresent()) {
            DevotionDto devotionDto = modelMapper.map(found.get(), DevotionDto.class);
            return Optional.of(devotionDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DevotionDto> updateDevotion(Long id, DevotionDto devotionDto) {
        Optional<Devotion> found = devotionRepository.findById(id);
        if (found.isPresent()) {
            modelMapper.map(devotionDto, found.get());
            Devotion saved = devotionRepository.save(found.get());
            DevotionDto devotionDto1 = modelMapper.map(saved, DevotionDto.class);
            return Optional.of(devotionDto1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DevotionDto> deleteDevotion(Long id) {
        Optional<Devotion> found = devotionRepository.findById(id);
        if (found.isPresent()) {
            devotionRepository.delete(found.get());
            DevotionDto devotionDto = modelMapper.map(found.get(), DevotionDto.class);
            return Optional.of(devotionDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<DevotionDto>> getDevotionByMemberId(Long memberId) {
        Optional<List<Devotion>> found = devotionRepository.findByMemberId(memberId);
        if (found.isPresent()) {
            List<DevotionDto> devotionDto = found.get().stream()
                    .map(devotion -> modelMapper.map(devotion, DevotionDto.class))
                    .collect(Collectors.toList());
            return Optional.of(devotionDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<DevotionDto>> getAllDevotions() {
        List<Devotion> devotions = devotionRepository.findAll();
        if (devotions.isEmpty()) {
            return Optional.empty();
        }
        List<DevotionDto> devotionDto = modelMapper.map(devotions, new TypeToken<List<DevotionDto>>() {}.getType());
        return Optional.of(devotionDto);
    }

}
