package com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeDesignation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long role_Id;
	private String role_Name;

	// Getters and Setters

	public Long getRoleId() {
		return role_Id;
	}

	public void setRoleId(Long roleId) {
		this.role_Id = roleId;
	}

	public String getRoleName() {
		return role_Name;
	}

	public void setRoleName(String roleName) {
		this.role_Name = roleName;
	}
}
