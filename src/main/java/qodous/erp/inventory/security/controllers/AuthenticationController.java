package qodous.erp.inventory.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qodous.erp.inventory.security.domain.AuthenticationRequest;
import qodous.erp.inventory.security.domain.AuthenticationResponse;
import qodous.erp.inventory.security.domain.RegisterRequest;
import qodous.erp.inventory.security.services.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        System.out.println("$$.. in register api");
        return ResponseEntity.ok( authService.register(registerRequest));
    }

    @PostMapping( "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate( @RequestBody AuthenticationRequest authRequest ){
        System.out.println("$$.. in authenticate api");
        return ResponseEntity.ok( authService.authenticate(authRequest));
    }
}
