package com.ViewWiser.security.controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ViewWiser.security.dataBaseModel.AssetManagement;

 
@RestController
public class AssetManagementController 
{
	@Autowired
    private AssetManagementService service;
 
   @PostMapping("/addAsset")	
   public ResponseEntity<?> addAssetToTable(@RequestBody String data)
	{
	service.addAssetToTable(data);
	return new ResponseEntity<>(HttpStatus.OK);
   }
	
	@GetMapping("/getassets")
	public List<AssetManagement> getAssets(){
		return service.getAssetLists();
	}
	
	@PostMapping("/deleteAsset/{id}")
	public ResponseEntity<?> deleteAsset(@PathVariable int id){
		service.deleteAsset(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
