package com.api.parkingspot.services;

import java.util.List;

import com.api.parkingspot.models.ParkingSpotModel;

public interface ParkingSpotService {

	public ParkingSpotModel save(ParkingSpotModel parkingSportModel);

	public boolean existsByLicensePlateCar(String licensePlateCar);
	
	public boolean existsByparkingSpotNumber(String parkingSpotNumber);
	
	public boolean existsByApartmentAndBlock(String apartment, String block);

	public List<ParkingSpotModel> findAll();

}
