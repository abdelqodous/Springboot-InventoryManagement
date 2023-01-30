//package qodous.erp.inventory.configuration;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.ManyToMany;
//import jakarta.validation.constraints.Email;
//import qodous.erp.security.domain.Role;
//import qodous.erp.security.domain.User;
//
//public class ErpUserDetails implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//
//	private Integer id;
//	private String firstName;
//	private String middleName;
//	private String lastName;
//	private String username;
//	private String mobile;
//	private String email;
//	private String passwordHash;
//	private Date registeredAt;
//	private Date lastLogin;
//	private String intro;
//	private String profile;
//	private Integer isActive;
//	private List<GrantedAuthority> roles;
//	
//	public ErpUserDetails(User theUser) {
//		super();
//		this.id = theUser.getId();
//		this.firstName = theUser.getFirstName();
//		this.middleName = theUser.getMiddleName();
//		this.lastName = theUser.getLastName();
//		this.username = theUser.getUsername();
//		this.mobile = theUser.getMobile();
//		this.email = theUser.getEmail();
//		this.passwordHash = theUser.getPasswordHash();
//		this.registeredAt = theUser.getRegisteredAt();
//		this.lastLogin = theUser.getLastLogin();
//		this.intro = theUser.getIntro();
//		this.profile = theUser.getProfile();
//		this.isActive = theUser.getIsActive();
////		this.roles = theUser.getRoles();
//		this.roles = Arrays.stream("1,2".split(",") )
//				.map(SimpleGrantedAuthority :: new)
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
