package tech.inno100.tryjesusapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.auth.AuthenticationRequest;
import tech.inno100.tryjesusapp.auth.AuthenticationResponse;
import tech.inno100.tryjesusapp.config.JwtService;
import tech.inno100.tryjesusapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        //do authentication
        //If authentication fails, authenticate() throws AuthenticationException
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        //check user is available in database
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );


        //generate token
        String token  = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
