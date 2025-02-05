package com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeDesignationMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;
    private Long employeeId;
    private Long roleId;

    // Constructors
    public EmployeeDesignationMapping() {
    }

    public EmployeeDesignationMapping(Long mappingId, Long employeeId, Long roleId) {
        this.mappingId = mappingId;
        this.employeeId = employeeId;
        this.roleId = roleId;
    }

    // Getters and Setters
    public Long getMappingId() {
        return mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDesignationId(Object roleId2) {
		// TODO Auto-generated method stub
		
	}

	public Long getDesignationId() {
		// TODO Auto-generated method stub
		return null;
	}
}
