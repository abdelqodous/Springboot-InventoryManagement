package qodous.erp.inventory.security.services;

import qodous.erp.inventory.security.domain.AuthenticationRequest;
import qodous.erp.inventory.security.domain.RegisterRequest;
import qodous.erp.inventory.security.domain.AuthenticationResponse;

public interface IAuthenticationService {
    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authRequest);
}
