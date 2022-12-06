package com.api.parkingspot.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingspot.models.ParkingSpotModel;
import com.api.parkingspot.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

	private final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	@Override
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSportModel) {
		return parkingSpotRepository.save(parkingSportModel);
	}
	
	@Override
	public List<ParkingSpotModel> findAll() {
		return parkingSpotRepository.findAll();
	}

	@Override
	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return parkingSpotRepository.existsBylicensePlateCar(licensePlateCar);
	}

	@Override
	public boolean existsByparkingSpotNumber(String parkingSpotNumber) {
		return parkingSpotRepository.existsByparkingSpotNumber(parkingSpotNumber);
	}

	@Override
	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	
	
	
}
