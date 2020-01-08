package com.ViewWiser.security.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ViewWiser.security.dataBaseModel.AssetCategories;
/** controller for categories**/ 
@RestController
public class AssetCategoriescontroller {
	
@Autowired
private AssetCategoriesService service;/** Service is Autowired for dependency **/

@PostMapping("/addCategories")/** post mapping for add categories to table in request body**/
public ResponseEntity<?> addCategories(@RequestBody String data)
{       
	return service.addAssetCategories(data);/** calling function from service[AssetCategoriesService] and passing the parameter to that function**/
 }
	
@GetMapping("/getAssetCategories")/** get existing categories from database**/
public List<AssetCategories> getAssetCategories()
{
	return service.getAssetCategories();
}

@GetMapping("/deleteAssetCategories/{id}")/** deleting asset categories from database by passsing the id**/
public ResponseEntity<?> deleteAssetCategories(@PathVariable int id)
{
	return service.deleteAssetCategories(id);
 }

}
