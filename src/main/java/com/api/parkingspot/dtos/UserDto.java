package com.api.parkingspot.dtos;

import javax.validation.constraints.NotBlank;

public class UserDto {

	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
}
