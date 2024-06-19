package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.OfferingDto;

import java.util.List;
import java.util.Optional;

public interface OfferingService {
    Optional<OfferingDto> addOffering(OfferingDto offeringDto);
    Optional<OfferingDto> updateOffering(Long offeringId, OfferingDto offeringDto);
    Optional<OfferingDto> deleteOffering(Long offeringId);
    Optional<OfferingDto> getOffering(Long offeringId);
    Optional<List<OfferingDto>> getAllOfferingsByMemberId(Long memberId);
    Optional <List<OfferingDto>> getAllOfferings();
}
