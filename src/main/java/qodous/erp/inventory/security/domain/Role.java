package qodous.erp.inventory.security.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue
	private Integer roleId;
	private String roleNameAr;
	private String roleNameEn;
	private String note;
	@ManyToMany(mappedBy = "userRoles")
	private List<User> users;
}
