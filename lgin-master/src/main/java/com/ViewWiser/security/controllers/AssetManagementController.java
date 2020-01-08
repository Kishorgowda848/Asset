package com.ViewWiser.security.controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    private AssetManagementService service;/***getting service from AssetManagementService class***/
 
   @PostMapping("/addAsset")/** it is for adding asset to table**/	
   public ResponseEntity<?> addAssetToTable(@RequestBody String data)
	{
	   return service.addAssetToTable(data);
    }
	
	@GetMapping("/getassets")/** it is for getting all assets**/
	public List<AssetManagement> getAssets(){
		return service.getAssetLists();
	}
	
	@PostMapping("/deleteAsset/{id}")/***to delete particular asset [Soft delete]**/
	public ResponseEntity<?> deleteAsset(@PathVariable int id){
		return service.deleteAsset(id);
 	}
	
}
