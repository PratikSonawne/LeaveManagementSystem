package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Dao;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeDesignation {

	@Id

	private Long roleId;
	private String roleName;

	// Getters and Setters

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
