package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.OfferingDto;
import tech.inno100.tryjesusapp.service.OfferingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/offerings")
public class OfferingController {
    private final OfferingService offeringService;

    @PostMapping("/member/{id}")
    public ResponseEntity<OfferingDto> addOffering(@PathVariable("id") Long id, @RequestBody OfferingDto offeringDto){
        Optional<OfferingDto> offeringDtoOptional = offeringService.addOffering(id, offeringDto);
        if(offeringDtoOptional.isPresent()){
            return ResponseEntity.ok(offeringDtoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/offering/{id}")
    public ResponseEntity<OfferingDto> updateOffering(@PathVariable("id") Long id, @RequestBody OfferingDto offeringDto){
        Optional<OfferingDto> offeringDto1 = offeringService.updateOffering(id, offeringDto);
        if(offeringDto1.isPresent()){
            return ResponseEntity.ok(offeringDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/offering/{id}")
    public ResponseEntity<OfferingDto> deleteOffering(@PathVariable("id") Long offeringId){
        Optional<OfferingDto> offering = offeringService.deleteOffering(offeringId);
        if(offering.isPresent()){
            return ResponseEntity.ok(offering.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/offering/{id}")
    public ResponseEntity<OfferingDto> getOffering(@PathVariable("id") Long offeringId){
        Optional<OfferingDto> offering = offeringService.getOffering(offeringId);
        if(offering.isPresent()){
            return ResponseEntity.ok(offering.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<List<OfferingDto>> getAllOfferingsByMemberId(@PathVariable("id") Long memberId){
        Optional<List<OfferingDto>> offerings  = offeringService.getAllOfferingsByMemberId(memberId);
        if(offerings.isPresent()){
            return ResponseEntity.ok(offerings.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:write', 'admin:read')")
    public ResponseEntity<List<OfferingDto>> getAllOfferings(){
        Optional<List<OfferingDto>> offerings = offeringService.getAllOfferings();
        if(offerings.isPresent()){
            return ResponseEntity.ok(offerings.get());
        }
        return ResponseEntity.notFound().build();
    }
}
