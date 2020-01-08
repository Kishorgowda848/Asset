package com.ViewWiser.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ViewWiser.security.dataBaseModel.AssetModel;

@RestController
public class AssetModelController 
{
@Autowired
private AssetModelService service;

@PostMapping("/addAssetModel")/** Adding asset model**/
public ResponseEntity<?> addAssetCategories(@RequestBody String data){
	return service.addAssetModel(data);
}

@GetMapping("/deleteAssetModel/{id}")/** deleting particular asset**/  
public ResponseEntity<?> deleteModel(@PathVariable int id){
	return service.deleteAssetModel(id);
}

@GetMapping("/getAssetModel")/** getting all assetModel**/
public List<AssetModel> getAssetModel(){
	return service.getAssetModel();
}

}
