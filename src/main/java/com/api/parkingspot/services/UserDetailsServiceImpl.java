package com.api.parkingspot.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.parkingspot.models.UserModel;
import com.api.parkingspot.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	protected UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel usermodel = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
	
		return usermodel;
	}
	
	public UserModel createUser(UserModel user) {
		return userRepository.save(user);
	}

}
