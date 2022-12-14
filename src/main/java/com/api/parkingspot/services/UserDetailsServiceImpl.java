package com.api.parkingspot.services;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.parkingspot.models.UserModel;
import com.api.parkingspot.repositories.UserRepository;

@Service
@Transactional // Allows to read user roles from tb_users_roles table as eager mode
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	protected UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel usermodel = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
	
		return new User(usermodel.getUsername(), usermodel.getPassword(), true, true, true, true, usermodel.getAuthorities());
	}
	
	public UserModel createUser(UserModel user) {
		return userRepository.save(user);
	}

}
