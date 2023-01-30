package qodous.erp.security.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	public Role() {
		
	}
	
	public Role(Integer roleId, String roleNameAr, String roleNameEn, String note) {
		super();
		this.roleId = roleId;
		this.roleNameAr = roleNameAr;
		this.roleNameEn = roleNameEn;
		this.note = note;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleNameAr() {
		return roleNameAr;
	}

	public void setRoleNameAr(String roleNameAr) {
		this.roleNameAr = roleNameAr;
	}

	public String getRoleNameEn() {
		return roleNameEn;
	}

	public void setRoleNameEn(String roleNameEn) {
		this.roleNameEn = roleNameEn;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleNameAr=" + roleNameAr + ", roleNameEn=" + roleNameEn + ", note=" + note
				+ "]";
	}
}
