package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services;
import java.util.List;
import java.util.Optional;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;

public interface EmployeeDesignationServices {
    List<EmployeeDesignation> getAllDesignations();
    Optional<EmployeeDesignation> getDesignationById(Long roleId);
    EmployeeDesignation createDesignation(EmployeeDesignation employeeDesignation);
    EmployeeDesignation updateDesignation(Long roleId, EmployeeDesignation employeeDesignation);
    void deleteDesignation(Long roleId);
}
