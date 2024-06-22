package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.PrayerRequestDto;
import tech.inno100.tryjesusapp.service.PrayerRequestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prayers")
public class PrayerRequestController {
    private final PrayerRequestService prayerRequestService;

    @PostMapping("/member/{id}")
    public ResponseEntity<PrayerRequestDto> addPrayerRequest(@PathVariable("id") Long id, @RequestBody PrayerRequestDto prayerRequestDto){
        Optional<PrayerRequestDto> prayerRequestDto1 = prayerRequestService.addPrayerRequest(id, prayerRequestDto);
        if(prayerRequestDto1.isPresent()){
            return ResponseEntity.ok().body(prayerRequestDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("prayer/{id}")
    public ResponseEntity<PrayerRequestDto> getPrayerRequestById(@PathVariable("id") Long id){
        Optional<PrayerRequestDto> prayerRequestDto1 = prayerRequestService.getPrayerRequestById(id);
        if(prayerRequestDto1.isPresent()){
            return ResponseEntity.ok().body(prayerRequestDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PrayerRequestDto>> getAllPrayerRequests(){
        Optional<List<PrayerRequestDto>> prayerRequestDto1 = prayerRequestService.getAllPrayerRequests();
        if(prayerRequestDto1.isPresent()){
            return ResponseEntity.ok().body(prayerRequestDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("prayer/{id}")
    public ResponseEntity<PrayerRequestDto> deletePrayerRequestById(@PathVariable("id") Long id){
        prayerRequestService.deletePrayerRequestById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<List<PrayerRequestDto>> getAllPrayerRequestsByMemberId(@PathVariable("id") Long userId){
        Optional<List<PrayerRequestDto>> prayerRequestDtos = prayerRequestService.getAllPrayerRequestsByMemberId(userId);
        if(prayerRequestDtos.isPresent()){
            return ResponseEntity.ok().body(prayerRequestDtos.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<PrayerRequestDto>> getAllPrayerRequestsByCategory(@PathVariable("category") String category){
        Optional<List<PrayerRequestDto>> prayer = prayerRequestService.getAllPrayerRequestsByCategory(category);
        if(prayer.isPresent()){
            return ResponseEntity.ok().body(prayer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("prayer/{id}")
    public ResponseEntity<PrayerRequestDto> updatePrayerRequest(@PathVariable Long id, @RequestBody PrayerRequestDto prayerRequestDto){
        Optional<PrayerRequestDto> prayer = prayerRequestService.updatePrayerRequest(id, prayerRequestDto);
        if(prayer.isPresent()){
            return ResponseEntity.ok().body(prayer.get());
        }
        return ResponseEntity.notFound().build();
    }
}
