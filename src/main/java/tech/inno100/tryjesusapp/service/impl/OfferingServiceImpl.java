package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.*;
import tech.inno100.tryjesusapp.model.*;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.repository.OfferingRepository;
import tech.inno100.tryjesusapp.service.OfferingService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferingServiceImpl implements OfferingService {
    private final OfferingRepository offeringRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<OfferingDto> addOffering(Long id, OfferingDto offeringDto){
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member not found");
        }
        Offering offering = modelMapper.map(offeringDto, Offering.class);
        offering.setMember(member.get());
        Offering savedOffering = offeringRepository.save(offering);
        OfferingDto offeringDto1 = modelMapper.map(savedOffering, OfferingDto.class);
        return Optional.of(offeringDto1);
    }

    @Override
    public Optional<OfferingDto> updateOffering(Long offeringId, OfferingDto offeringDto){
        Optional<Offering> found = offeringRepository.findById(offeringId);
        if (found.isPresent()) {
            modelMapper.map(offeringDto, found.get());
            Offering saved = offeringRepository.save(found.get());
            OfferingDto offeringDto1 = modelMapper.map(saved, OfferingDto.class);
            return Optional.of(offeringDto1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OfferingDto> deleteOffering(Long offeringId){
        Optional<Offering> found = offeringRepository.findById(offeringId);
        if (found.isPresent()) {
            offeringRepository.delete(found.get());
            OfferingDto offeringDto = modelMapper.map(found.get(), OfferingDto.class);
            return Optional.of(offeringDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OfferingDto> getOffering(Long offeringId){
        Optional<Offering> found = offeringRepository.findById(offeringId);
        if (found.isPresent()) {
            OfferingDto offeringDto = modelMapper.map(found.get(), OfferingDto.class);
            return Optional.of(offeringDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<OfferingDto>> getAllOfferingsByMemberId(Long memberId){
        Optional<List<Offering>> found = offeringRepository.findByMemberId(memberId);
        if (found.isPresent()) {
            List<OfferingDto> offeringDtos = found.get().stream()
                    .map(offering -> modelMapper.map(offering, OfferingDto.class))
                    .collect(Collectors.toList());
            return Optional.of(offeringDtos);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<OfferingDto>> getAllOfferings(){
        List<Offering> offerings = offeringRepository.findAll();
        if (offerings.isEmpty()) {
            return Optional.empty();
        }
        List<OfferingDto> offeringDtos = modelMapper.map(offerings, new TypeToken<List<OfferingDto>>() {}.getType());
        return Optional.of(offeringDtos);
    }
}
