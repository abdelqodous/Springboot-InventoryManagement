package qodous.erp.security.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "middleName")
	private String middleName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "username")
	private String userName;
	@Column(name = "mobile")
	private String mobile;
	@Email
	@Column(name = "email")
	private String email;
	@Column(name = "passwordHash")
	@JsonIgnore
	private String passwordHash;
	@Column(name = "registeredAt")
	private Date registeredAt;
	@Column(name = "lastLogin")
	private Date lastLogin;
	@Column(name = "intro")
	private String intro;
	@Column(name = "profile")
	private String profile;
	@Column(name = "isActive")
	private Integer isActive;
	@ManyToMany
	private List<Role> roles;

	@Override
	public String toString() {
		return "$$.. User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", userName=" + userName + ", mobile=" + mobile + ", email=" + email
				+ ", passwordHash=" + passwordHash + ", registeredAt=" + registeredAt + ", lastLogin=" + lastLogin
				+ ", intro=" + intro + ", profile=" + profile + ", isActive=" + isActive + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Role role: getRoles()) {
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
