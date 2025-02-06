package com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeDesignation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;
	private String rolename;

	// Getters and Setters

	public Long getRoleId() {
		return roleid;
	}

	public void setRoleId(Long roleId) {
		this.roleid = roleId;
	}

	public String getRoleName() {
		return rolename;
	}

	public void setRoleName(String roleName) {
		this.rolename = roleName;
	}
}
