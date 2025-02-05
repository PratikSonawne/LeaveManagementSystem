package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;
public interface EmployeeDesignationMappingRepository extends JpaRepository<EmployeeDesignation, Long> {
}