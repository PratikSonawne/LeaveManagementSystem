package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services;
import java.util.List;
import java.util.Optional;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.EmployeeModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

public interface EmployeeDetailsServices {
	
	 
	  EmployeeDetails saveEmployee(EmployeeDetails employee);
	    List<EmployeeDetails> getAllEmployees();
	    Optional<EmployeeDetails> getEmployeeById(Long id);
	    EmployeeDetails updateEmployee(Long id, EmployeeDetails employee);
	    void deleteEmployee(Long id);
		EmployeeDetails roleId(EmployeeDesignationMapping mapping);
		EmployeeDetails mappingId(EmployeeDetails employee);		

		EmployeeDetails saveEmployee(EmployeeDesignationMapping mapping);
		EmployeeModel createEmployee(EmployeeModel employeeModel);

}

