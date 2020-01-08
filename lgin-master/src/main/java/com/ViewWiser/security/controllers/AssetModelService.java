package com.ViewWiser.security.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.ViewWiser.security.dataBaseModel.AssetCategories;
import com.ViewWiser.security.dataBaseModel.AssetCategoriesRepository;
import com.ViewWiser.security.dataBaseModel.AssetModel;
import com.ViewWiser.security.dataBaseModel.AssetModelRepository;

@Service
public class AssetModelService 
{
	/*** assetModelRepository,assetCategoriesRepository to save and get data **/
@Autowired	
 private AssetModelRepository assetModelRepository;
@Autowired
private AssetCategoriesRepository assetCategoriesRepository;

/** To add Asset Model for particular AssetCategories**/
public ResponseEntity<?> addAssetModel(String data)
{
	JSONObject json=new JSONObject(data);
	AssetCategories assetCategoriesId=assetCategoriesRepository.findById(json.getInt("CategoriesId"));/*** find categoriesId to save in table***/
	if(assetCategoriesId!=null) 
	{
		AssetModel assetmodel=new AssetModel(json.getString("modelName"),true);/** adding model name**/
		assetmodel.setAssetCategoriesId(assetCategoriesId);/** setting catId**/
		assetModelRepository.save(assetmodel);/*** save repository***/
		return new ResponseEntity<>(HttpStatus.OK);
	}else
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}


public ResponseEntity<?> deleteAssetModel(int id)
{
	AssetModel assetModel=assetModelRepository.findById(id);/** finding ID in Repository**/
	if(assetModel!=null) 
	{
    assetModel.setActive(false);/** soft delete by setting false **/
    assetModelRepository.save(assetModel);/** save to repository**/
	return new ResponseEntity<>(HttpStatus.OK);
	}else
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}


public List<AssetModel> getAssetModel()
{
	return assetModelRepository.findAll().stream().filter(i->i.isActive()==true).collect(Collectors.toList());/** getting all the data**/
}
 
}
