package qodous.erp.security.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "roleId")
	private Integer roleId;
	@Column(name = "roleNameAr")
	private String roleNameAr;
	@Column(name = "roleNameEn")
	private String roleNameEn;
	@Column(name = "note")
	private String note;

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleNameAr=" + roleNameAr + ", roleNameEn=" + roleNameEn + ", note=" + note
				+ "]";
	}
}
