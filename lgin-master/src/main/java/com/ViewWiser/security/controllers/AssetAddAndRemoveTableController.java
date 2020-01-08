package com.ViewWiser.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ViewWiser.security.dataBaseModel.AssetAddAndRemoveTable;

@RestController
public class AssetAddAndRemoveTableController 
{
    @Autowired
    private AssetAddAndRemoveTableService service;/*** Service provided from AssetAddAndRemoveTableService**/
   
    /***Add Asset to user by providing  "UserId","AssetId","issueDate"  passing as request body  **********/
    @PostMapping("/addAssetToUser")
    public ResponseEntity<?> addAssetToUser(@RequestBody String data)
    {
    	return service.addAsset(data);
    }
    
    /** to fetch all the users[registered with assets] **/
	@GetMapping("/getAllAllocatedAssets")
	public List<AssetAddAndRemoveTable> getAllAllocatedUsers()
	{
		return service.getAllAllocatedAssetAndUserInfo();
	}
	/** find info of particular user**/
	@GetMapping("/getParticularuserInfo/{id}")
	public  List<AssetAddAndRemoveTable> getParticularUserInfo(@PathVariable int id)
	{
		return service.getParticularUserInfo(id);
	}
	@PostMapping("/returningAsset")
	public ResponseEntity<?> returningAsset(@RequestBody String data){
		return service.returningAsset(data);
	}
	
}
