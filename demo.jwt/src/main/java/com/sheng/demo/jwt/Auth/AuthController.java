package com.sheng.demo.jwt.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheng.demo.jwt.models.AuthResponse;
import com.sheng.demo.jwt.models.LoginRequest;
import com.sheng.demo.jwt.models.RegisterRequest;
import com.sheng.demo.jwt.service.IAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private IAuthService authService;
	
	@PostMapping(value="login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		
		return ResponseEntity.ok(authService.login(request)); 
	}
	
	@PostMapping(value="register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
		
		return ResponseEntity.ok(authService.register(request));
	}	
}
