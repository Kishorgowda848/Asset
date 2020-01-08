package com.ViewWiser.security.controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.ViewWiser.security.AssetUser;

@RestController
public class UserRegisterationController {
	
	@Autowired
	private UserRegisterationService service;/** to perform operation on service**/
 
	
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody String data)
    {
    	return service.userRegister(data);
    }
    
    @PostMapping("/userDetails")
    public ResponseEntity<?> registeruserDetails(@RequestBody String data)
    {
    	return service.userregisterationDetails(data);
    }

/*** to get all registered users info**/
   @GetMapping("/getRegisteredList")
   public List<AssetUser> getRegisteredList()
   {
	return service.getUserRegisteredList();
   }

/** to get particular user information**/   
   @GetMapping("/userDetails/{id}")
   public AssetUser userDetail(@PathVariable int id) 
   {
	return service.userDetails(id);
  }
}
