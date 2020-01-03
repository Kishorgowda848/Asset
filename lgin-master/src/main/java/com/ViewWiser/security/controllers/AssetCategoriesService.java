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
	

  public ResponseEntity<?> addAssetCategories(String data)
    {
		JSONObject json=new JSONObject(data);
		AssetCategories categories=new AssetCategories(json.getString("assetCategories"), true);
		assetCategoriesRepository.save(categories);
		return new ResponseEntity<>(HttpStatus.OK);
	}

  
  public ResponseEntity<?> deleteAssetCategories(int id)
  {
	 AssetCategories categories=assetCategoriesRepository.findById(id);
	 categories.setActive(false);
	  assetCategoriesRepository.save(categories);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
  
  public List<AssetCategories> getAssetCategories()
  {
	  return assetCategoriesRepository.findAll().stream().filter(i->i.isActive()==true).collect(Collectors.toList());
  }

}
