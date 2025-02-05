package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDesignationServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;

@RestController
@RequestMapping("/api/designations")
public class EmployeeDesignationController {

    private final EmployeeDesignationServices employeeDesignationServices;

    @Autowired
    public EmployeeDesignationController(EmployeeDesignationServices employeeDesignationService) {
        this.employeeDesignationServices = employeeDesignationService;
    }

    // Get all designations
    @GetMapping
    public List<EmployeeDesignation> getAllDesignations() {
        return employeeDesignationServices.getAllDesignations();
    }

    // Get a designation by ID
    @GetMapping("/{roleId}")
    public ResponseEntity<EmployeeDesignation> getDesignationById(@PathVariable Long roleId) {
        Optional<EmployeeDesignation> designation = employeeDesignationServices.getDesignationById(roleId);
        return designation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new designation
    @PostMapping
    public ResponseEntity<EmployeeDesignation> createDesignation(@RequestBody EmployeeDesignation employeeDesignation) {
        EmployeeDesignation createdDesignation = employeeDesignationServices.createDesignation(employeeDesignation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDesignation);
    }

    // Update an existing designation
    @PutMapping("/{roleId}")
    public ResponseEntity<EmployeeDesignation> updateDesignation(
            @PathVariable Long roleId, @RequestBody EmployeeDesignation employeeDesignation) {
        EmployeeDesignation updatedDesignation = employeeDesignationServices.updateDesignation(roleId, employeeDesignation);
        return updatedDesignation != null ? ResponseEntity.ok(updatedDesignation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a designation
    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long roleId) {
        employeeDesignationServices.deleteDesignation(roleId);
        return ResponseEntity.noContent().build();
    }
}
