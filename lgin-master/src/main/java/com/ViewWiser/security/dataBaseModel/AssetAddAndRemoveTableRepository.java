package com.ViewWiser.security.dataBaseModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetAddAndRemoveTableRepository extends JpaRepository<AssetAddAndRemoveTable, Integer>{
 AssetAddAndRemoveTable findById(int id);/** To find record by id [Mainly used in API]**/
 
}
