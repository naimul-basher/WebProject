package com.Web.dto;

public class LoginDTO {
	
	String username, password;
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
