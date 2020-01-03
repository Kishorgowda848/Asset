package com.ViewWiser.security.controllers;

import java.time.LocalDate;

import org.hibernate.type.LocalDateType;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ViewWiser.security.dataBaseModel.AssetLinkToUser;
import com.ViewWiser.security.dataBaseModel.AssetLinkToUserRepository;
import com.ViewWiser.security.dataBaseModel.AssetManagement;
import com.ViewWiser.security.dataBaseModel.AssetMangementRepository;
import com.ViewWiser.security.dataBaseModel.UserDetailsCostumClass;
import com.ViewWiser.security.dataBaseModel.UserDetailsCostumRepository;

@Service
public class AssetLinkToUserService {
	@Autowired
    private AssetLinkToUserRepository assetLinkToUserRepository;
	@Autowired
	private AssetMangementRepository assetManagementRepository;
	@Autowired
	private UserDetailsCostumRepository userDetailsCostumRepository;
	
	@PostMapping("/addAssetToUser")
 public ResponseEntity<?> addAssetToUsers(String data){
		JSONObject json=new JSONObject(data);
		LocalDate checkinDate=LocalDate.now(); 
	AssetManagement assetId=assetManagementRepository.findById(json.getInt("id"));
	UserDetailsCostumClass userId= userDetailsCostumRepository.findById(json.getInt("id"));
	AssetLinkToUser asset=new AssetLinkToUser(checkinDate);
 	asset.setAssetManagement(assetId);
 	asset.setUserDetailsCostumClass(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
