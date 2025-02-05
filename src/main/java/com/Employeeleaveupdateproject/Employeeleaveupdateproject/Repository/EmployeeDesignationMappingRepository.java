package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
public interface EmployeeDesignationMappingRepository extends JpaRepository<EmployeeDesignation, Long> {

	EmployeeDesignationMapping save(EmployeeDesignationMapping mapping);
}