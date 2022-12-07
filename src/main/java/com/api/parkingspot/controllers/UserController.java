package com.api.parkingspot.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingspot.dtos.UserDto;
import com.api.parkingspot.models.UserModel;
import com.api.parkingspot.services.UserDetailsServiceImpl;

@RestController("/usuarios")
public class UserController {

	private final UserDetailsServiceImpl userserviDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	protected UserController(UserDetailsServiceImpl userserviDetailsService, PasswordEncoder passwordEncoder) {
		this.userserviDetailsService = userserviDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto userDto) {
		
		UserModel user = new UserModel();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return ResponseEntity.status(HttpStatus.CREATED).body(userserviDetailsService.createUser(user));
	}
}
