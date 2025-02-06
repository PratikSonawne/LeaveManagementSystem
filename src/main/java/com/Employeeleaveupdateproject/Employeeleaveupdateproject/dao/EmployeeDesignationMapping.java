package com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data 
public class EmployeeDesignationMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mappingId;
    private Integer employeeId;
    private Integer roleId;

   
}
