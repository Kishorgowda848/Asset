package com.ViewWiser.security.dataBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ViewWiser.security.AssetUser;

/** UserDeatilsCostumClass table creation in database**/
@Entity
@Table(name="UserInfo")
public class UserDetailsCostumClass {
	@Id/** to make Primary key ID in database**/
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
    private AssetUser userID;/** AssetUser class is getting from Security package with one to one relation**/
 	
 /** all are getters and setters**/
	public int getId() 
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
	public AssetUser getUserID() {
		return userID;
	}
	public void setUserID(AssetUser userID)
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
