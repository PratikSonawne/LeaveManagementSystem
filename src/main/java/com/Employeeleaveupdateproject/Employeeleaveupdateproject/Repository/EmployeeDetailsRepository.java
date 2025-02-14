package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

	boolean existsByEmail(String email);
    // Your query methods

	boolean existsByMobileNo(String mobileNo);

	boolean existsById(Integer id);

	void deleteById(Integer id);

	Optional<EmployeeDetails> findByEmail(String email );
	Optional<EmployeeDetails> findByPassword(String password);

	Optional<EmployeeDetails> findByMobileNo(String mobileNo);

	boolean existsByMobileNoAndPassword(String mobileNo, String password);

	boolean existsByEmailAndPassword(String email, String password);

	Optional<EmployeeDetails> findByEmployeeId(Integer employeeId);


	}

