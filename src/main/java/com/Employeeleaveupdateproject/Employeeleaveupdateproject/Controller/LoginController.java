package com.Employeeleaveupdateproject.Employeeleaveupdateproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Model.LoginPageModel;
import com.Employeeleaveupdateproject.Employeeleaveupdateproject.Services.LoginServices;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private LoginServices loginServices;

	@PostMapping("/login")
	public LoginPageModel loginUser(@RequestBody LoginPageModel loginRequest) {
		try {
			LoginPageModel loginUser = loginServices.loginUser(loginRequest);
			return loginUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
