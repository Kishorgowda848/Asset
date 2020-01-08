package com.ViewWiser.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/** Jpa repository for login user table */
public interface AssetUserRepository extends JpaRepository<AssetUser, Integer> {
	Optional<AssetUser> findByUserName(String userName);
    AssetUser findById(int id);
}
