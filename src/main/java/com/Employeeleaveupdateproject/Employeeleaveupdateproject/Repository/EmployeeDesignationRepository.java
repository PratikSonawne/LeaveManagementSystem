package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;

@Repository
public interface EmployeeDesignationRepository extends JpaRepository<EmployeeDesignation, Integer> {


	List<EmployeeDesignation> findAll();
   
}
