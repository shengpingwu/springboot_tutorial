package com.sheng.demo.jwt.service;

import com.sheng.demo.jwt.models.AuthResponse;
import com.sheng.demo.jwt.models.LoginRequest;
import com.sheng.demo.jwt.models.RegisterRequest;

public interface IAuthService {
	public AuthResponse login(LoginRequest request);

	public AuthResponse register(RegisterRequest request);
}

