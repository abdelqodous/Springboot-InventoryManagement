package qodous.erp.inventory.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.stereotype.Service;
import qodous.erp.inventory.security.repositories.IUserRepository;
import qodous.erp.inventory.security.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
	}
}
