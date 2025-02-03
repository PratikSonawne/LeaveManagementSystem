package com.Employeeleaveupdateproject.Employeeleaveupdateproject;

import org.springframework.boot.SpringApplication;

public class TestEmployeeleaveupdateprojectApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmployeeleaveupdateprojectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
