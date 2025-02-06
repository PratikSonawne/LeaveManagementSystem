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
    private Long roleid;

    // Constructors
    public EmployeeDesignationMapping() {
    }

    public EmployeeDesignationMapping(Long mappingId, Long employeeId, Long roleId) {
        this.mappingId = mappingId;
        this.employeeId = employeeId;
        this.roleid = roleId;
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
        return roleid;
    }

    public void setRoleId(Long roleid) {
        this.roleid = roleid;
    }

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDesignationId(Object roleid2) {
		// TODO Auto-generated method stub
		
	}

	public Long getDesignationId() {
		// TODO Auto-generated method stub
		return null;
	}
}
