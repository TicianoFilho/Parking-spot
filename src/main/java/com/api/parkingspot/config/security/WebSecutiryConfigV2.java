package com.api.parkingspot.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // New way of implementing Spring Security. No more extends WebSecurityConfigurerAdapter, it works through components as follows.
@EnableGlobalMethodSecurity(prePostEnabled = true) // enables annotations in each method in controller for each roles.
public class WebSecutiryConfigV2 {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.
			httpBasic()
			.and()
			.authorizeHttpRequests()
//			.antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()
//			.antMatchers(HttpMethod.POST, "/parking-spot").hasAnyRole("ROLE_ADMIN, ROLE_USER")
//			.antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ROLE_ADMIN")
			.anyRequest().authenticated()
			.and()
			.csrf().disable();
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
