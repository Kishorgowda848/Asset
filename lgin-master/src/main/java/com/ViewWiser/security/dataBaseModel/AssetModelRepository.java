package com.ViewWiser.security.dataBaseModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetModelRepository extends  JpaRepository<AssetModel, Integer>{
	AssetModel findById(int id);

}
