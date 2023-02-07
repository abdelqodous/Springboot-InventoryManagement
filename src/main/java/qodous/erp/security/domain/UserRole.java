package qodous.erp.security.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "user_role")
public class UserRole {
    @Id
    @Column( name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "userId")
	private User user;
    @ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
	 
		 
}
