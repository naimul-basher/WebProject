package com.Web.validation;

import com.Web.dto.RegDTO;

public class RegistrationValidation {
	private String errorMsg; 
	
	boolean isString (String str) {
		
		for(char c : str.toCharArray() ) {
	        if(Character.isDigit(c)){
	            return false;
	        } 
	    }
		
		return true;
	}
	
	boolean isNumeric (String str) {
		
		for(char c : str.toCharArray() ) {
	        if(Character.isAlphabetic(c)){
	            return false;
	        } 
	    }
		
		return true;
		
	}
	
	public String validateUserCredentials(RegDTO regDTO) {
		
		if ( regDTO.getFirstName().length() < 6 || !isString( regDTO.getFirstName() ) ) {
			System.out.println("First name format not ok");
			errorMsg = "First name format not ok";
			return errorMsg;
		}

		else if ( regDTO.getLastName().length() < 6 || !isString( regDTO.getLastName() ) ) {
			System.out.println("Last name format not ok");
			errorMsg = "Last name format not ok";
			return errorMsg;
		}

		else if ( !( regDTO.getUsername().length() >= 4 && regDTO.getUsername().length() <=8) || 
				!regDTO.getUsername().matches("^[^\\d].*") ) {
			
			System.out.println("Username format not ok");
			errorMsg = "Username format not ok";
			return errorMsg;
		}
		
		else if ( !regDTO.getPhone().startsWith("+") || !isNumeric( regDTO.getPhone().substring(1) ) ) {
			
			System.out.println("Phone number format not ok");
			errorMsg = "Phone number format not ok";
			return errorMsg;
		}
		
		else if ( regDTO.getAddress() == "") {
			
			System.out.println("Address shouldn't be blank");
			errorMsg = "Address shouldn't be blank";
			return errorMsg;
		}
		
		else if ( regDTO.getEmail() == "" || !regDTO.getEmail().matches("^(.+)@(.+)$")) {
			
			System.out.println("Email format not ok");
			errorMsg = "Email format not ok";
			return errorMsg;
		}
		
		else if ( regDTO.getPassword().length() < 5 )  {
			
			System.out.println("Password should be greater than 5 digits");
			errorMsg = "Password should be greater than 5 digits";
			return errorMsg;
		}
		
		return null;
	}
}
