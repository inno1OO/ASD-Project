package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.inno100.tryjesusapp.auth.AuthenticationRequest;
import tech.inno100.tryjesusapp.auth.AuthenticationResponse;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.exception.member.MemberNotFoundException;
import tech.inno100.tryjesusapp.service.AuthenticationService;
import tech.inno100.tryjesusapp.service.MemberService;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> addMember( @RequestBody MemberDto memberDto) {
        AuthenticationResponse responseDto = memberService.addNewMember(memberDto);
//        if (responseDto.) {
//            return ResponseEntity.ok(responseDto.get());
//        }
        return ResponseEntity.ok(responseDto);
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(@RequestBody MemberDto registerRequest) {
//        AuthenticationResponse response = authenticationService.register(registerRequest);
//        return ResponseEntity.ok(response);
//    }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse memberDto = authenticationService.authenticate(request);
        if (memberDto.toString().isEmpty()) {

            throw new MemberNotFoundException("Wrong username or password");
        }else{
            return ResponseEntity.ok(memberDto);
        }
//        return ResponseEntity.ok(
//                authenticationService.authenticate(request)
//        );
    }
}
