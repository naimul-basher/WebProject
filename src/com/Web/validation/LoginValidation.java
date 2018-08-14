package com.Web.validation;

import com.Web.dto.LoginDTO;

public class LoginValidation {
	
	private String errorMsg;

	public LoginValidation() {
		// TODO Auto-generated constructor stub
	}
	
public String validateUserCredentials(LoginDTO loginDTO) {
		
		if ( !( loginDTO.getUsername().length() >= 4 && loginDTO.getUsername().length() <=8) || 
				!loginDTO.getUsername().matches("^[^\\d].*") ) {
			
			System.out.println("Username format not ok");
			errorMsg = "Username format not ok";
			return errorMsg;
		}
		
		else if ( loginDTO.getPassword().length() < 5 )  {
			
			System.out.println("Password should be greater than 5 digits");
			errorMsg = "Password should be greater than 5 digits";
			return errorMsg;
		}
		
		return null;
	}

}
