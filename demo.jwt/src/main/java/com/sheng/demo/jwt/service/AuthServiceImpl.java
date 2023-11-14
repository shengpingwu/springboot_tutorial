package com.sheng.demo.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sheng.demo.jwt.models.AuthResponse;
import com.sheng.demo.jwt.models.LoginRequest;
import com.sheng.demo.jwt.models.RegisterRequest;
import com.sheng.demo.jwt.models.Role;
import com.sheng.demo.jwt.models.User;
import com.sheng.demo.jwt.repository.IUserRepository;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IJwtService jwtService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public AuthResponse login(LoginRequest request) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		
		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();
	}

	@Override
	public AuthResponse register(RegisterRequest request) {
		
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();
	}

}
