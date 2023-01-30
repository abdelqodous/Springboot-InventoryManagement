//package qodous.erp.security.services.impl;
//
//import java.util.Collection;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import qodous.erp.inventory.configuration.ErpUserDetails;
//import qodous.erp.security.domain.User;
//import qodous.erp.security.repositories.UserRepository;
//import qodous.erp.security.services.IUserService;
//
//public class UserServiceImpl implements UserDetailsService, IUserService {
//	
//	private static final long serialVersionUID = 1L;
//	
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public Optional<User> findByUserName(String userName) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findByUserName(username);
//		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + user));
//		return user.map(ErpUserDetails::new).get();
////		return new ErpUserDetails(user);
//	}
//}
