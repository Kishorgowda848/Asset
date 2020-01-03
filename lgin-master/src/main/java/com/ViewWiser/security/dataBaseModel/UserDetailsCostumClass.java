package com.ViewWiser.security.dataBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToOne;

import com.ViewWiser.security.Users;

/** UserDeatilsCostumClass table creation in database**/
@Entity
public class UserDetailsCostumClass {
	@Id/* to generate ID in database**/
	@GeneratedValue(strategy = GenerationType.IDENTITY)/** to make ID as Auto increment and primary key*/
    private int id;
	@Column(name="name")
    private String name;
	@Column(name="phoneNumber")
    private long phoneNumber;
	@Column(name="address")
    private String address;
	@Column(name="source")
    private String source;
 	@OneToOne
    private Users userID;/** Users class is getting from Security package with one to one relation**/
 	
 	
	public int getId() /** all are getters and setters**/
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Users getUserID() {
		return userID;
	}
	public void setUserID(Users userID)
	{
		this.userID = userID;
	}
	public UserDetailsCostumClass(String name, long phoneNumber, String address, String source)/** Parameterized constructor**/
	{
 		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.source = source;
	}


}
