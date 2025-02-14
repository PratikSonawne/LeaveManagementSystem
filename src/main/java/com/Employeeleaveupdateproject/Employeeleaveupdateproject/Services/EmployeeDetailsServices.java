package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services;
import java.util.List;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.EmployeeModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

public interface EmployeeDetailsServices {
	
	    List<EmployeeDetails> getAllEmployees();
		EmployeeModel createEmployee(EmployeeModel employeeModel);
		

}

