package com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Entity
@Data
@Table(name = "employee_details")
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

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
    private String password;
    
	
}













