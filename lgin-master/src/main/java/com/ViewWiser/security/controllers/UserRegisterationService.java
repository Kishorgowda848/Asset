package com.ViewWiser.security.controllers;

 
import java.util.List;
import java.util.stream.Collectors;
 
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ViewWiser.security.AssetUserRepository;
import com.ViewWiser.security.AssetUser;
import com.ViewWiser.security.dataBaseModel.UserDetailsCostumClass;
import com.ViewWiser.security.dataBaseModel.UserDetailsCostumRepository;
 

@Service/** this is the service class**/ /** this provides service to controller class**/
public class UserRegisterationService {

	@Autowired
	 public AssetUserRepository userRepository;/** to save user authentication info to this repository**/
	@Autowired
	 public UserDetailsCostumRepository userDetailsCostumClassRepository; /** to save userDetails to repository*/
 /****/
   public ResponseEntity<?> userRegister(String data) 
    {
 		JSONObject json=new JSONObject(data);/** the data is in string format that will converted into json format**/ 
 	    System.out.println(json.getString("email"));
	    AssetUser user=new AssetUser(json.getString("email"),json.getString("password"), json.getString("role"), true);
 	    userRepository.save(user);/*** save to repository**/
	    
	  return new ResponseEntity<>(HttpStatus.OK);
	}
   
   public ResponseEntity<?> userregisterationDetails(String data)
   {
		JSONObject json=new JSONObject(data);/** the data is in string format that will converted into json format**/ 
	    AssetUser userId=userRepository.findById(json.getInt("UserId"));
	    
	    if(userId==null)
	    {
	    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }else {
		    UserDetailsCostumClass userDetails= new UserDetailsCostumClass(json.getString("name"),json.getLong("phoneNumber"),json.getString("address"), "our web");
	    userDetails.setUserID(userId);
	    userDetailsCostumClassRepository.save(userDetails);/*** save to repository**/
		   return new ResponseEntity<>(HttpStatus.OK);
	    }
    }
   

/** to get all registered user**/
   public List<AssetUser> getUserRegisteredList()
   {
	return   userRepository.findAll().stream().filter(i->i.getActive()==true).collect(Collectors.toList());
   }

/** to get particular user information**/
   public AssetUser userDetails(int id) 
   {
 	return userRepository.findById(id);
   }
}
