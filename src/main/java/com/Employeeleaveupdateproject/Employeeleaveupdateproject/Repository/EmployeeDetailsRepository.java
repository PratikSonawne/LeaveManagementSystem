package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

	boolean existsByEmail(String email);
    // Your query methods

	boolean existsByMobileNo(String mobileNo);
}

