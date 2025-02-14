package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;
public interface EmployeeDesignationMappingRepository extends JpaRepository<EmployeeDesignationMapping, Integer> {


	Optional<EmployeeDesignationMapping> findByEmployeeId(Integer employeeId);

	EmployeeDesignationMapping save(EmployeeDesignation mapping);


}