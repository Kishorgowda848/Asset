package com.ViewWiser.security.dataBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*** this is the categories Entity class**/
@Entity
@Table(name="AssetCategories")
public class AssetCategories 
{
	
@Id/*** to create primary key in Database**/
@GeneratedValue(strategy = GenerationType.IDENTITY)/** to make id filed auto generated value**/
private int id;
@Column
private String name; /**for categories name field**/
@Column
private boolean active;/** for soft delete**/

/** it is all about getters and setters**/
public AssetCategories(String name, boolean active) {
 	this.name = name;
	this.active = active;
}
public int getId() {
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
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public AssetCategories() {}

}
