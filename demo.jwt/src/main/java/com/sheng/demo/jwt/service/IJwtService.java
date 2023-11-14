package com.sheng.demo.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

	public String getToken(UserDetails user);
	
	
	public String getUsernameFromToken(String token);


	public boolean isTokenValid(String token, UserDetails userDetails);
}
