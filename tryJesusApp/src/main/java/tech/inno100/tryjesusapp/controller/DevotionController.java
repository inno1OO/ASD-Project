package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.DevotionDto;
import tech.inno100.tryjesusapp.service.DevotionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/devotions")
public class DevotionController {
    private final DevotionService devotionService;

    @PostMapping("/member/{id}")
    public ResponseEntity<DevotionDto> addDevotion(@PathVariable("id") Long id, @RequestBody DevotionDto devotionDto){
       Optional<DevotionDto> devotion = devotionService.addDevotion(id, devotionDto);
       if(devotion.isPresent()){
           return ResponseEntity.ok(devotion.get());
       }
       return ResponseEntity.notFound().build();
    }

    @GetMapping("/devotion/{id}")
    public ResponseEntity<DevotionDto> getDevotion(@PathVariable("id") Long id){
        Optional<DevotionDto> devotion = devotionService.getDevotion(id);
        if(devotion.isPresent()){
            return ResponseEntity.ok(devotion.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/devotion/{id}")
    public ResponseEntity<DevotionDto> updateDevotion(@PathVariable("id") Long id, @RequestBody DevotionDto devotionDto){
        Optional<DevotionDto> devotion = devotionService.updateDevotion(id, devotionDto);
        if(devotion.isPresent()){
            return ResponseEntity.ok(devotion.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/devotion/{id}")
    Optional<DevotionDto> deleteDevotion(@PathVariable("id") Long id){
        Optional<DevotionDto> devotion = devotionService.getDevotion(id);
        if(devotion.isPresent()){
            devotionService.deleteDevotion(id);
        }
        return devotion;
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<List<DevotionDto>> getDevotionByMemberId(@PathVariable("id") Long memberId){
        Optional<List<DevotionDto>> devotionDto = devotionService.getDevotionByMemberId(memberId);
        if(devotionDto.isPresent()){
            return ResponseEntity.ok(devotionDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('member:read', 'member:write', 'admin:write', 'admin:read')")
    public ResponseEntity<List<DevotionDto>> getAllDevotions(){
        Optional<List<DevotionDto>> devotions = devotionService.getAllDevotions();
        if(devotions.isPresent()){
            return ResponseEntity.ok(devotions.get());
        }
        return ResponseEntity.notFound().build();
    }
}
