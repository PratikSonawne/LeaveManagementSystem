package com.Employeeleaveupdateproject.Employeeleaveupdateproject.ServicesImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDesignationRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDesignationServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;

@Service
public class EmployeeDesignationServicesImpl implements EmployeeDesignationServices {

    private final EmployeeDesignationRepository employeeDesignationRepository;

    @Autowired
    public EmployeeDesignationServicesImpl(EmployeeDesignationRepository employeeDesignationRepository) {
        this.employeeDesignationRepository = employeeDesignationRepository;
    }

    @Override
    public List<EmployeeDesignation> getAllDesignations() {
        return employeeDesignationRepository.findAll();
    }

    @Override
    public Optional<EmployeeDesignation> getDesignationById(Long roleId) {
        return employeeDesignationRepository.findById(roleId);
    }

    @Override
    public EmployeeDesignation createDesignation(EmployeeDesignation employeeDesignation) {
        return employeeDesignationRepository.save(employeeDesignation);
    }

    @Override
    public EmployeeDesignation updateDesignation(Long roleId, EmployeeDesignation employeeDesignation) {
        if (employeeDesignationRepository.existsById(roleId)) {
            employeeDesignation.setRoleId(roleId);
            return employeeDesignationRepository.save(employeeDesignation);
        }
        return null; // Or throw an exception if not found
    }

    @Override
    public void deleteDesignation(Long roleId) {
        employeeDesignationRepository.deleteById(roleId);
    }
}
