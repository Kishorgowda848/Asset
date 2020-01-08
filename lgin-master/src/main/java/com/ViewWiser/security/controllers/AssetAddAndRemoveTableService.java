package com.ViewWiser.security.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ViewWiser.security.AssetUser;
import com.ViewWiser.security.AssetUserRepository;
import com.ViewWiser.security.dataBaseModel.AssetAddAndRemoveTable;
import com.ViewWiser.security.dataBaseModel.AssetAddAndRemoveTableRepository;
import com.ViewWiser.security.dataBaseModel.AssetManagement;
import com.ViewWiser.security.dataBaseModel.AssetMangementRepository;

@Service
public class AssetAddAndRemoveTableService {
@Autowired
private AssetAddAndRemoveTableRepository addAndRemoveTableRepsitory;
@Autowired
private AssetUserRepository assetUserRepository;
@Autowired
private AssetMangementRepository assetMangementRepository;

/** adding asset to particular User By providing the UserID ,issueDate and AssetID**/
public ResponseEntity<?> addAsset(String data)
{
	JSONObject json=new JSONObject(data);/** converting into json data**/
	
	AssetUser user=assetUserRepository.findById(json.getInt("UserId"));/** finding user for particular UserId**/
	AssetManagement asset=assetMangementRepository.findById(json.getInt("AssetId"));/** finding Asset for particular AssetId**/
	if(user!=null&&asset!=null) 
	{
		LocalDate returnDate=LocalDate.parse(json.getString("issueDate"));/** converting String into LocalDate**/
		AssetAddAndRemoveTable addAsset=new AssetAddAndRemoveTable(returnDate);/*** adding value to database**/
		addAsset.setUserId(user);
		addAsset.setAssetId(asset);/** setting UserId and AssetId**/
		addAndRemoveTableRepsitory.save(addAsset);/** save it repository**/
 		return new ResponseEntity<>(HttpStatus.OK);
	}
	else
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}

/** getting all Allocated device to users with info**/

public List<AssetAddAndRemoveTable> getAllAllocatedAssetAndUserInfo()
{
	return addAndRemoveTableRepsitory.findAll();
}

/** getting information for particular user**/
/** this is the list because one user can have many Assets**/
public List<AssetAddAndRemoveTable> getParticularUserInfo(int id) 
{
	AssetUser user=assetUserRepository.findById(id);
	return addAndRemoveTableRepsitory.findAll().stream().filter(i->i.getUserId()==user).collect(Collectors.toList());
	/** converting into stream with filter and collects**/
}

public ResponseEntity<?> returningAsset(String data)
{
	JSONObject json=new JSONObject(data);
	 AssetAddAndRemoveTable user=addAndRemoveTableRepsitory.findById(json.getInt("AssetManagementId"));/** finding addAndRemoveTableRepsitory particular UserId**/
	if(user!=null)
    {
    	LocalDate returnDate=LocalDate.now();
    	user.setReturnDate(returnDate);
        addAndRemoveTableRepsitory.save(user);
    	return  new ResponseEntity<>(HttpStatus.OK);
    }else	
 	return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	
}

}
