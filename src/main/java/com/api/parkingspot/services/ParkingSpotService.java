package com.api.parkingspot.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.parkingspot.models.ParkingSpotModel;

public interface ParkingSpotService {

	public ParkingSpotModel save(ParkingSpotModel parkingSportModel);

	public boolean existsByLicensePlateCar(String licensePlateCar);
	
	public boolean existsByparkingSpotNumber(String parkingSpotNumber);
	
	public boolean existsByApartmentAndBlock(String apartment, String block);

	public Page<ParkingSpotModel> findAll(Pageable pageable);

	public Optional<ParkingSpotModel> findOneById(UUID id);
	
	public void delete(ParkingSpotModel parkingSpotModel);

}
