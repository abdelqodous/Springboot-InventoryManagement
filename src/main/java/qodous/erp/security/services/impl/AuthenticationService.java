package qodous.erp.security.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import qodous.erp.configuration.JwtUtils;
import qodous.erp.security.domain.*;
import qodous.erp.security.repositories.IUserRepository;
import qodous.erp.security.services.IAuthenticationService;
import qodous.erp.security.services.IRoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authManager;
    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User
                .builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .userName(registerRequest.getUserName())
                .passwordHash(passwordEncoder.encode(registerRequest.getPassword()))
                .roles((List<Role>) roleService.findById(2).orElseThrow())
                .build();
        userRepository.save(user);
        var token = jwtUtils.generateToken(user);
        System.out.println("$$.. Token: " +token);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
        );
        UserDetails user = userRepository.findByUserName(authRequest.getUserName())
                .orElseThrow();
        var token = jwtUtils.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }
}
