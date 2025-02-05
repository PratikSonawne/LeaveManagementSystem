package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model;

import java.sql.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class EmployeeRoleMapping {

	private Long employeeId;

    private String firstName;
    private String lastName;
    private String gender;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    private String email;
    private String mobileNo;
    private String city;
    private String district;
    private String state;
    private String aadharNumber;
    private String panCardNumber;
	
}
