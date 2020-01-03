package com.ViewWiser.security.dataBaseModel;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne; 
import javax.persistence.OneToOne;

@Entity
public class AssetLinkToUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private UserDetailsCostumClass userDetailsCostumClass;
	@ManyToOne
	private AssetManagement assetManagement;
	@Column
	private LocalDate checkinDate;
	@Column
	private LocalDate checkoutDate;
	
	
 public AssetLinkToUser(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
 	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDetailsCostumClass getUserDetailsCostumClass() {
		return userDetailsCostumClass;
	}
	public void setUserDetailsCostumClass(UserDetailsCostumClass userDetailsCostumClass) {
		this.userDetailsCostumClass = userDetailsCostumClass;
	}
	public AssetManagement getAssetManagement() {
		return assetManagement;
	}
	public void setAssetManagement(AssetManagement assetManagement) {
		this.assetManagement = assetManagement;
	}
	public LocalDate getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}	
	
	
	
}
