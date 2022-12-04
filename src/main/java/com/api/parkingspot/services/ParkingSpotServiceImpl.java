package com.api.parkingspot.services;

import org.springframework.stereotype.Service;

import com.api.parkingspot.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

	private final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}
	
	
	
}
