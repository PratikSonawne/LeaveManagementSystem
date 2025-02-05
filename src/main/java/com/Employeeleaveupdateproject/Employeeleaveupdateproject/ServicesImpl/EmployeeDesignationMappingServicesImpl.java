package com.Employeeleaveupdateproject.Employeeleaveupdateproject.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Repository.EmployeeDesignationMappingRepository;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.EmployeeDesignationMappingServices;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignation;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.dao.EmployeeDesignationMapping;

@Service
public class EmployeeDesignationMappingServicesImpl implements EmployeeDesignationMappingServices {

    @Autowired
    private EmployeeDesignationMappingRepository repository;

    public List<EmployeeDesignation> getAllMappings() {
        return repository.findAll();
    }

    public EmployeeDesignation getMappingById(Long mappingId) {
        Optional<EmployeeDesignation> mapping = repository.findById(mappingId);
        return mapping.orElse(null);
    }

    public EmployeeDesignationMapping createMapping(EmployeeDesignationMapping mapping) {
        return repository.save(mapping);
    }

    public void deleteMapping(Long mappingId) {
        repository.deleteById(mappingId);
    }

    public EmployeeDesignationMapping saveMapping(EmployeeDesignationMapping mapping) {
        return repository.save(mapping);
    }

 

	@Override
	public EmployeeDesignation createMapping(EmployeeDesignation mapping) {
		System.out.println("Before saving: " + mapping);
        EmployeeDesignation savedMapping = repository.save(mapping);
        System.out.println("After saving: " + savedMapping);
        return savedMapping;
	}


}