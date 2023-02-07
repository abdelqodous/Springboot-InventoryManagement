package qodous.erp.security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qodous.erp.security.domain.AuthenticationRequest;
import qodous.erp.security.domain.AuthenticationResponse;
import qodous.erp.security.domain.RegisterRequest;
import qodous.erp.security.services.IAuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        System.out.println("$$.. in register api");
        return ResponseEntity.ok( authService.register(registerRequest));
    }

    @GetMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate( @RequestBody AuthenticationRequest authRequest ){
        return ResponseEntity.ok( authService.authenticate(authRequest));
    }
}
