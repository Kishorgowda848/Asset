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

@Service
public class AssetCategoriesService
{
	@Autowired
    private AssetCategoriesRepository  assetCategoriesRepository;
	
/**  below ApI is for adding categories to database**/
  public ResponseEntity<?> addAssetCategories(String data)
    {
		try{
			JSONObject json=new JSONObject(data);/** converting string to json object**/
			AssetCategories categories=new AssetCategories(json.getString("assetCategories"), true);/** adding categories to table**/
			assetCategoriesRepository.save(categories);/** save the changes to repository**/
			return new ResponseEntity<>(HttpStatus.OK);
		  }/** if error occurs catch block will going to process**/
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

 		}
	}

  /**  below ApI is for deleting categories from database**/
  public ResponseEntity<?> deleteAssetCategories(int id)
  {
	AssetCategories categories=assetCategoriesRepository.findById(id);/** finding the particular record from the database**/
   if(categories!=null) /** if record is present then process**/
     {
	 categories.setActive(false);
	  assetCategoriesRepository.save(categories);
	  return new ResponseEntity<>(HttpStatus.OK);
     }
   else {
	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
  
  /**  below ApI is for getting all categories from database**/
  public List<AssetCategories> getAssetCategories()
  {
	  return assetCategoriesRepository.findAll().stream().filter(i->i.isActive()==true).collect(Collectors.toList());
	  /** findAll in  stream and filter with condition and convert into list**/
  }

}
