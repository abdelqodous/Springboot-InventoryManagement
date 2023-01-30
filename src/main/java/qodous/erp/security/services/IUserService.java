package qodous.erp.security.services;

import java.util.Optional;

import qodous.erp.security.domain.User;

public interface IUserService {
	
	Optional<User> findByUserName(String userName);
}
