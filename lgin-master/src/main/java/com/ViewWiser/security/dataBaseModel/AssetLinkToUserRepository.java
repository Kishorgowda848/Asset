package com.ViewWiser.security.dataBaseModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetLinkToUserRepository extends JpaRepository<AssetLinkToUser, Integer> {
AssetLinkToUser findById(int id);
}
