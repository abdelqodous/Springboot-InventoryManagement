package qodous.erp.security.services;

import qodous.erp.security.domain.AuthenticationRequest;
import qodous.erp.security.domain.RegisterRequest;
import qodous.erp.security.domain.AuthenticationResponse;

public interface IAuthenticationService {
    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authRequest);
}
