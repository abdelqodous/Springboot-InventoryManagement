package qodous.erp.inventory.security.domain;

import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String userName;
	private String mobile;
	private String email;
	private String passwordHash;
	private Date registeredAt;
	private Date lastLogin;
	private String intro;
	private String profile;
	private Integer isActive;
	@ManyToMany()
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> userRoles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Role role: getUserRoles()) {
			authorities.add( new SimpleGrantedAuthority(role.getRoleNameEn()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}