package com.ViewWiser.security.dataBaseModel;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 /*** this is the AssetManagement Entity class[create Asset Table in database**/

@Entity
@Table(name="Asset")
public class AssetManagement {
@Id/*** to create primary key in Database**/
@GeneratedValue(strategy =GenerationType.IDENTITY)/** make that id as auto generated vale**/
private	int id;

@Column
private String assetTag;
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
@OneToOne/** one to one relation with AssetModel**/
private AssetModel AssetModelId;
  
/** getters and setters**/
public AssetManagement(String assetTag,LocalDate purchaseDate,
		String description, int price, boolean flag,boolean active) 
{ 
	this.assetTag = assetTag;
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
public LocalDate getPurchaseDate() {
	return purchaseDate;
}

public AssetModel getAssetModelId() {
	return AssetModelId;
}

public void setAssetModelId(AssetModel assetModelId) {
	AssetModelId = assetModelId;
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
