package qodous.erp.inventory.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import qodous.erp.inventory.configuration.JwtService;
import qodous.erp.inventory.security.domain.*;
import qodous.erp.inventory.security.repositories.IUserRepository;
import qodous.erp.inventory.security.services.IAuthenticationService;
import qodous.erp.inventory.security.services.IRoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired IUserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired IRoleService roleService;
    @Autowired JwtService jwtService;
    @Autowired
    AuthenticationManager authManager;
    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        System.out.println("$$.. in AuthenticationService: register");
        List <Role> defaultRole = new ArrayList<>();
        defaultRole.add(roleService.findById(1).orElseThrow());
        var user = User
                .builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .userName(registerRequest.getUserName())
                .passwordHash(passwordEncoder.encode(registerRequest.getPassword()))
                .userRoles(defaultRole)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        System.out.println("$$.. Token: " +token);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        System.out.println("$$.. in AuthenticationService: authenticate");
        System.out.println("$$.. in AuthenticationService: " + authRequest.getUserName());
        System.out.println("$$.. authRequest.getPassword: " + authRequest.getPassword());
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
        );
        System.out.println("$$.. var user = userRepository.findByUserName ");
        var user = userRepository.findByUserName(authRequest.getUserName())
                .orElseThrow();
        System.out.println("$$.. last name: " +user.getLastName());
        var token = jwtService.generateToken(user);
        System.out.println("$$.. token: " +token);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }
}
