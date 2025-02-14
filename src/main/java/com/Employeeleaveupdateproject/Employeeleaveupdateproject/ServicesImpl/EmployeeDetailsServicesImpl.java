package com.Employeeleaveupdateproject.Employeeleaveupdateproject.ServicesImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.EmployeeModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDesignationMappingRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDetailsRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDetailsServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

@Service
public class EmployeeDetailsServicesImpl implements EmployeeDetailsServices {

	@Autowired
	private EmployeeDetailsRepository employeeRepository;

	@Autowired
	EmployeeDesignationMappingRepository mappingRepository;
  
	
	
	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepository.findAll();
	}

	
	
	@Override
	public EmployeeModel createEmployee(EmployeeModel employeeModel) {
		// Step 1: EmployeeDetails object create & save
		EmployeeDetails employee = new EmployeeDetails();
		employee.setFirstName(employeeModel.getFirstName());
		employee.setLastName(employeeModel.getLastName());
		employee.setGender(employeeModel.getGender());
		employee.setDateOfBirth(employeeModel.getDateOfBirth());
		employee.setEmail(employeeModel.getEmail());
		employee.setMobileNo(employeeModel.getMobileNo());
		employee.setCity(employeeModel.getCity());
		employee.setDistrict(employeeModel.getDistrict());
		employee.setState(employeeModel.getState());
		employee.setAadharNumber(employeeModel.getAadharNumber());
		employee.setPanCardNumber(employeeModel.getPanCardNumber());
		employee.setPassword(employeeModel.getPassword());
		// Save Employee
		EmployeeDetails savedEmployee = employeeRepository.save(employee);

		// Step 2: Mapping Table me data insert
		EmployeeDesignationMapping mapping = new EmployeeDesignationMapping();
		mapping.setEmployeeId(savedEmployee.getEmployeeId());
		mapping.setRoleId(employeeModel.getRoleId()); // mappingId store karna hai

		// Save Mapping
		 EmployeeDesignationMapping designationMapping = mappingRepository.save(mapping);

		return employeeModel;
	}


}




