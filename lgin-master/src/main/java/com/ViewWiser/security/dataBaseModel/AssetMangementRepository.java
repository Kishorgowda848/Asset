package com.ViewWiser.security.dataBaseModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetMangementRepository extends JpaRepository<AssetManagement, Integer> {
AssetManagement findById(int id);
}
