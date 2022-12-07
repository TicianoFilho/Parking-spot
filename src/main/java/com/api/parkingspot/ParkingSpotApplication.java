package com.api.parkingspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ParkingSpotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingSpotApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("abc123"));
	}

}
