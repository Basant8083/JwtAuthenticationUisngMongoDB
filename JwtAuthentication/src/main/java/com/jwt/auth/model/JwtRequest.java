package com.jwt.auth.model;

import org.springframework.stereotype.Component;

@Component
public class JwtRequest {
	
	private String username;
	private String password;
	
	
	public JwtRequest() {
		
	}
	public JwtRequest(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
