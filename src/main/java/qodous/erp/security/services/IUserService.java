package qodous.erp.security.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import qodous.erp.security.domain.User;

public interface IUserService extends UserDetailsService {

}
