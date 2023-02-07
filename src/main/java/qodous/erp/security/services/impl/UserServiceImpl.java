package qodous.erp.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import qodous.erp.security.repositories.IUserRepository;
import qodous.erp.security.services.IUserService;

public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepository IUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return IUserRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
	}
}
