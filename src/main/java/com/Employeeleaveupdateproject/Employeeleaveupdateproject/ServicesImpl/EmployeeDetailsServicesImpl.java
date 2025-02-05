package com.Employeeleaveupdateproject.Employeeleaveupdateproject.ServicesImpl;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.EmployeeModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDetailsRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDetailsServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.roleRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

@Service
public class EmployeeDetailsServicesImpl implements EmployeeDetailsServices {

    @Autowired
    private EmployeeDetailsRepository employeeRepository;
    public EmployeeDetails saveEmployee(EmployeeDetails employee) {
        // Check if email or mobile number already exists (optional validation)
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Employee with this email already exists.");
        }

        if (employeeRepository.existsByMobileNo(employee.getMobileNo())) {
            throw new RuntimeException("Employee with this mobile number already exists.");
        }

        // Save employee details
        return employeeRepository.save(employee);
    }

    public EmployeeDetails updateEmployee(Long id, EmployeeDetails updatedEmployee) {
        Optional<EmployeeDetails> existingEmployeeOptional = employeeRepository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            EmployeeDetails existingEmployee = existingEmployeeOptional.get();

            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setMobileNo(updatedEmployee.getMobileNo());
            existingEmployee.setCity(updatedEmployee.getCity());
            existingEmployee.setDistrict(updatedEmployee.getDistrict());
            existingEmployee.setState(updatedEmployee.getState());
            existingEmployee.setAadharNumber(updatedEmployee.getAadharNumber());
            existingEmployee.setPanCardNumber(updatedEmployee.getPanCardNumber());

            // Save the updated employee details
            return employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeDetails> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            // Handle case where employee with the provided ID doesn't exist
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }

    @Override
    public EmployeeDetails mappingId(EmployeeDetails employee) {
        if (employee != null) {
            // Assuming 'setId' is a setter in EmployeeDetails class to assign an ID.
            employee.setId(generateUniqueId());
            return employee;
        }
        return null;
    }


    private static final AtomicLong counter = new AtomicLong();

    private Long generateUniqueId() {
        return counter.incrementAndGet();  // Increment and return a new unique ID
    }

	@Override
	public EmployeeDetails roleId(EmployeeDesignationMapping mapping) {
	    if (mapping != null) {
	        // Assuming you have a method to fetch the employee based on the mapping
	        EmployeeDetails employee = findEmployeeByDesignation(mapping.getRoleId());
	        return employee;
	    }
	    return null;
	}

	private EmployeeDetails findEmployeeByDesignation(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDetails saveEmployee(EmployeeDesignationMapping mapping) {
		// TODO Auto-generated method stub
		return null;
	}
	 public static  EmployeeModel createEmployee(EmployeeModel employeeModel) {
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
	        
	        EmployeeDetailsServices employeedetailRepository= null;
			// Save Employee
	        EmployeeDetails savedEmployee = employeedetailRepository.saveEmployee(employee);

	        // Step 2: Mapping Table me data insert
	        EmployeeDesignationMapping mapping = new EmployeeDesignationMapping();
	        mapping.setEmployeeId(savedEmployee.getId());
	        mapping.setDesignationId(employeeModel.getMappingId()); // mappingId store karna hai

	        EmployeeDetailsServices mappingRepository = null;
			// Save Mapping
	        EmployeeDetails savedMapping = mappingRepository.saveEmployee(mapping);

	     // Step 3: Role Name Fetch Karna
	        EmployeeDetails role = null;
	        try {
	            role = roleRepository.findById(employeeModel.getMappingId())
	                    .orElseThrow(() -> new RuntimeException("Role not found"));
	        } catch (RuntimeException e) {
	            System.out.println("Error: " + e.getMessage()); 
	            throw new RuntimeException("Role with ID " + employeeModel.getMappingId() + " not found.");  // Custom exception message
	        }

	        
	        
	        // Step 4: Response Model create karna
	        EmployeeModel response = new EmployeeModel();
	        response.setFirstName(savedEmployee.getFirstName());
	        response.setLastName(savedEmployee.getLastName());
	        response.setGender(savedEmployee.getGender());
	        response.setDateOfBirth(savedEmployee.getDateOfBirth());
	        response.setEmail(savedEmployee.getEmail());
	        response.setMobileNo(savedEmployee.getMobileNo());
	        response.setCity(savedEmployee.getCity());
	        response.setDistrict(savedEmployee.getDistrict());
	        response.setState(savedEmployee.getState());
	        response.setAadharNumber(savedEmployee.getAadharNumber());
	        response.setPanCardNumber(savedEmployee.getPanCardNumber());
	        response.setMappingId(savedMapping.getMappingId());
	        response.setRoleName(role.getRoleName());
	        // Role ka naam database se fetch karna

	        return response;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	


}
