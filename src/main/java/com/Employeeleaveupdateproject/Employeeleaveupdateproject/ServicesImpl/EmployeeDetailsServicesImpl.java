package com.Employeeleaveupdateproject.Employeeleaveupdateproject.ServicesImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDetailsRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDetailsServices;
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
	public EmployeeDetails roleId(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDetails mappingId(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
