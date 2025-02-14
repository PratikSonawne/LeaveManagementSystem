package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}




