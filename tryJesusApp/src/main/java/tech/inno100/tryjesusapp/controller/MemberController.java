package tech.inno100.tryjesusapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> addMember( @RequestBody MemberDto memberDto) {
        Optional<MemberDto> responseDto = memberService.addNewMember(memberDto);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Long id) {
        Optional<MemberDto> responseDto = memberService.getMember(id);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
//        throw new CustomerNotFoundException(id + " not found");
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable("id") Long id, @RequestBody MemberDto member){
        Optional<MemberDto> responseDto = memberService.updateMember(id, member);
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MemberDto> deleteMember(@PathVariable Long id){
        Optional<MemberDto> responseDto = memberService.deleteMember(id);
        if (responseDto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers(){
        Optional<List<MemberDto>> responseDto = memberService.getAllMembers();
        if (responseDto.isPresent()) {
            return ResponseEntity.ok(responseDto.get());
        }
        return ResponseEntity.notFound().build();
    }
}