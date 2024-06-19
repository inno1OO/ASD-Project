package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.OfferingDto;
import tech.inno100.tryjesusapp.repository.OfferingRepository;
import tech.inno100.tryjesusapp.service.OfferingService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferingServiceImpl implements OfferingService {
    private final OfferingRepository offeringRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<OfferingDto> addOffering(OfferingDto offeringDto){
        return Optional.empty();
    }

    @Override
    public Optional<OfferingDto> updateOffering(Long offeringId, OfferingDto offeringDto){
        return Optional.empty();
    }

    @Override
    public Optional<OfferingDto> deleteOffering(Long offeringId){
        return Optional.empty();
    }

    @Override
    public Optional<OfferingDto> getOffering(Long offeringId){
        return Optional.empty();
    }

    @Override
    public Optional<List<OfferingDto>> getAllOfferingsByMemberId(Long memberId){
        return Optional.empty();
    }

    @Override
    public Optional<List<OfferingDto>> getAllOfferings(){
        return Optional.empty();
    }
}
