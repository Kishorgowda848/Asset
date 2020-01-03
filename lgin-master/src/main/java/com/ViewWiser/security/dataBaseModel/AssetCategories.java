package com.ViewWiser.security.dataBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssetCategories {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String name;
@Column
private boolean active;

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
