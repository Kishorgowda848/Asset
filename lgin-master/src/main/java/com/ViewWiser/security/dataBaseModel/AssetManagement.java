package com.ViewWiser.security.dataBaseModel;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class AssetManagement {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private	int id;
@Column
private String assetTag;
@Column
private String model;
@Column
private String categories;
@Column
private LocalDate purchaseDate;
@Column
private String description;
@Column
private int price;
@Column
private boolean flag;
@Column
private boolean active;


public AssetManagement(String assetTag, String model, String categories, LocalDate purchaseDate,
		String description, int price, boolean flag,boolean active) 
{ 
	this.assetTag = assetTag;
	this.model = model;
	this.categories = categories;
	this.purchaseDate = purchaseDate;
	this.description = description;
	this.price = price;
	this.flag = flag;
	this.active=active;
 }

public AssetManagement() {}
public int getId() {
	return id;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public void setId(int id) {
	this.id = id;
}
public String getAssetTag() {
	return assetTag;
}
public void setAssetTag(String assetTag) {
	this.assetTag = assetTag;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getCategories() {
	return categories;
}
public void setCategories(String categories) {
	this.categories = categories;
}
public LocalDate getPurchaseDate() {
	return purchaseDate;
}
public void setPurchaseDate(LocalDate purchaseDate) {
	this.purchaseDate = purchaseDate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public boolean getFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
 
}
