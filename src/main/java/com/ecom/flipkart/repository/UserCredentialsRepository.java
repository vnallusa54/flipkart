package com.ecom.flipkart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.flipkart.entity.UserCredentialsEntity;

public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, Long>{

	public Optional<UserCredentialsEntity> findByUserId(String userId);
}
