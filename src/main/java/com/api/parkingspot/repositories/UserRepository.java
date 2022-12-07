package com.api.parkingspot.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingspot.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

	Optional<UserModel> findByUsername(String username);

}
