package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.EmployeeModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDetailsServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

@RestController
@RequestMapping("/api/employees")
public class EmployeeDetailsController {

    @Autowired
    private EmployeeDetailsServices employeeServices;
    
    @PostMapping("/add")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel) {
        try {
        	EmployeeModel response = employeeServices.createEmployee(employeeModel);
            return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			return null;
		}
    }

     
    @GetMapping
    public ResponseEntity<List<EmployeeDetails>> getAllEmployees() {
        return ResponseEntity.ok(employeeServices.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeDetails>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeServices.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDetails employee) {
        return ResponseEntity.ok(employeeServices.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeServices.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}



