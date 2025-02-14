package com.Employeeleaveupdateproject.Employeeleaveupdateproject.ServicesImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.LoginPageModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDesignationMappingRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDetailsRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.LoginServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoginServicesImpl implements LoginServices {
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	@Autowired
	private EmployeeDesignationMappingRepository employeeDesignationMappingRepository;
	
	@Override
	public LoginPageModel loginUser(LoginPageModel loginRequest) {
	    System.out.println("Login request received for email: " + loginRequest.getEmail());
 
	    if (loginRequest.getEmail() != null && loginRequest.getPassword() != null) {
	        Optional<EmployeeDetails> employeeOpt = employeeDetailsRepository.findByEmail(loginRequest.getEmail());
 
	        if (!employeeOpt.isPresent()) {
	            System.out.println("Email not found!");
	            loginRequest.setMessage("Email ID is invalid");
	            return loginRequest;
	        }
 
	        EmployeeDetails employee = employeeOpt.get();
	        System.out.println("Found employee: " + employee.getEmployeeId());
 
	        if (!employee.getPassword().equals(loginRequest.getPassword().trim())) {  
	            System.out.println("Stored password: [" + employee.getPassword() + "]");  
	            System.out.println("Entered password (trimmed): [" + loginRequest.getPassword().trim() + "]");  
	            System.out.println("Password does not match!");  
	            loginRequest.setMessage("Password is invalid");  
	            return loginRequest;  
	        }

	        loginRequest.setMessage("Login successful");
	        loginRequest.setUserId(employee.getEmployeeId());
 
	        Optional<EmployeeDesignationMapping> roleOpt = employeeDesignationMappingRepository.findByEmployeeId(employee.getEmployeeId());
 
	        if (roleOpt.isPresent()) {
	            System.out.println("Role ID found: " + roleOpt.get().getRoleId());
	            loginRequest.setRoleId(roleOpt.get().getRoleId());
	        } else {
	            System.out.println("No role mapping found for Employee ID: " + employee.getEmployeeId());
	            throw new EntityNotFoundException("No role mapping found for Employee ID: " + employee.getEmployeeId());
	        }
	    }
	    return loginRequest;
	}
 

}