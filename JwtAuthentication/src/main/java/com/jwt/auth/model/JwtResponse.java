package com.jwt.auth.model;

import org.springframework.stereotype.Component;

@Component
public class JwtResponse {
	
	private String token;

	
	public JwtResponse() {
		
	}
	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
