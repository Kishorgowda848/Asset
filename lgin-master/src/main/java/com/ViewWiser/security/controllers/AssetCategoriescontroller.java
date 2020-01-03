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

import com.ViewWiser.security.dataBaseModel.AssetCategories;

@RestController
public class AssetCategoriescontroller {
	
@Autowired
private AssetCategoriesService service;

@PostMapping("/addCategories")
public ResponseEntity<?> addCategories(@RequestBody String data)
{       
	    service.addAssetCategories(data);
		return new ResponseEntity<>(HttpStatus.OK);
}
	
@GetMapping("/getAssetCategories")
public List<AssetCategories> getAssetCategories()
{
	return service.getAssetCategories();
}

@GetMapping("/deleteAssetCategories/{id}")
public ResponseEntity<?> deleteAssetCategories(@PathVariable int id)
{
	service.deleteAssetCategories(id);
	return new ResponseEntity<>(HttpStatus.OK);
}

}
