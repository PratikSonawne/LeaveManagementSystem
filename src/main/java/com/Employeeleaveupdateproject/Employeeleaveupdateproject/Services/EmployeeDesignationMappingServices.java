package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services;
import java.util.List;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
public interface EmployeeDesignationMappingServices {
    List<EmployeeDesignation> getAllMappings();
    EmployeeDesignation getMappingById(Long mappingId);
    EmployeeDesignation createMapping(EmployeeDesignation mapping);
    void deleteMapping(Long mappingId);
	EmployeeDesignationMapping saveMapping(EmployeeDesignationMapping mapping);
}
