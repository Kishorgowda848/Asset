package com.ViewWiser.security.dataBaseModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetCategoriesRepository extends JpaRepository<AssetCategories, Integer> {
AssetCategories findById(int id);
}
