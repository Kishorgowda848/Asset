package com.ViewWiser.security.controllers;

 
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.ViewWiser.security.dataBaseModel.AssetManagement;
import com.ViewWiser.security.dataBaseModel.AssetMangementRepository;
import com.ViewWiser.security.dataBaseModel.AssetModel;
import com.ViewWiser.security.dataBaseModel.AssetModelRepository;

@Service
public class AssetManagementService {
	@Autowired
    private AssetMangementRepository assetMangementRepository;
	@Autowired
	private AssetModelRepository assetModelRepository;
	
 public ResponseEntity<?> addAssetToTable(String data)
 {
	JSONObject json=new JSONObject(data);/*** converting  string to json object**/
	LocalDate date= LocalDate.parse(json.getString("date")); /*** parsing the data**/  
	AssetManagement asset=new AssetManagement(json.getString("assetTag"),date,json.getString("description"),json.getInt("price"),true,true);
	AssetModel assetModel=assetModelRepository.findById(json.getInt("AssetModelID"));
	asset.setAssetModelId(assetModel);
	assetModelRepository.save(assetModel);
 	assetMangementRepository.save(asset);/** save to asset Management Repository**/
	return new ResponseEntity<>(HttpStatus.OK);
}
 
 /** to get all assets **/
 public  List<AssetManagement> getAssetLists()
 {
	 /** find all element in stream with filter and make them to store in list**/
	return assetMangementRepository.findAll().stream().filter(i->i.isActive()==true).collect(Collectors.toList()); 
 }
	
 /** to remove particular asset**/
 public ResponseEntity<?> deleteAsset(int id){
	 AssetManagement asset =assetMangementRepository.findById(id);
	 asset.setActive(false);
	 assetMangementRepository.save(asset);
	 return new  ResponseEntity<>(HttpStatus.OK);
 }
}
