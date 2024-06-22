package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.TestimonyDto;
import tech.inno100.tryjesusapp.model.Testimony;
import tech.inno100.tryjesusapp.repository.TestimonyRepository;
import tech.inno100.tryjesusapp.service.TestimonyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testimonies")
public class TestimonyController {
    private final TestimonyService testimonyService;

    @PostMapping("/member/{id}")
    public ResponseEntity<TestimonyDto> addTestimony(@PathVariable("id") Long id, @RequestBody TestimonyDto testimonyDto){
        Optional<TestimonyDto> testimony = testimonyService.addTestimony(id, testimonyDto);
        if(testimony.isPresent()){
            return ResponseEntity.ok(testimony.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/testimony/{id}")
    public ResponseEntity<TestimonyDto> updateTestimony(@PathVariable("id") Long testimonyId, @RequestBody TestimonyDto testimonyDto){
        Optional<TestimonyDto> testimonyDto1 = testimonyService.updateTestimony(testimonyId, testimonyDto);
        if(testimonyDto1.isPresent()){
            return ResponseEntity.ok(testimonyDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("testimony/{id}")
    public ResponseEntity<TestimonyDto> deleteTestimony(@PathVariable("id") Long testimonyId){
        Optional<TestimonyDto> testimonyDto1 = testimonyService.deleteTestimony(testimonyId);
        if(testimonyDto1.isPresent()){
            return ResponseEntity.ok(testimonyDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("testimony/{id}")
    public ResponseEntity<TestimonyDto> getTestimony(@PathVariable("id") Long testimonyId){
        Optional<TestimonyDto> testimonyDto1 = testimonyService.getTestimony(testimonyId);
        if(testimonyDto1.isPresent()){
            return ResponseEntity.ok(testimonyDto1.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TestimonyDto>> getAllTestimonys(){
        Optional<List<TestimonyDto>> testimonyDtos = testimonyService.getAllTestimonys();
        if(testimonyDtos.isPresent()){
            return ResponseEntity.ok(testimonyDtos.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<List<TestimonyDto>> getAllTestimonysByMemberId(@PathVariable("id") Long testimonyId){
        Optional<List<TestimonyDto>> testimonyDtos = testimonyService.getAllTestimonysByMemberId(testimonyId);
        if(testimonyDtos.isPresent()){
            return ResponseEntity.ok(testimonyDtos.get());
        }
        return ResponseEntity.notFound().build();
    }
}
