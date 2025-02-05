package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;

@Repository
public interface EmployeeDesignationRepository extends JpaRepository<EmployeeDesignation, Long> {


	List<EmployeeDesignation> findAll();

	Optional<EmployeeDesignation> findById(Long roleId);

}
