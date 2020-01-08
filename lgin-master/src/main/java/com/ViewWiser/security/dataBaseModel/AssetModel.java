package com.ViewWiser.security.dataBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AssetModel")
public class AssetModel {

	@Id/** make primary key**/
	@GeneratedValue(strategy = GenerationType.IDENTITY)/** to make AutoIncrement**/
	private int id;
	@Column
	private String modelName;
	@ManyToOne/** many to One RelationShip with AssetCategories**/
	private AssetCategories assetCategoriesId;
	@Column
	private boolean active;
	
	/** All About Getters and Setters**/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelName() {
		return modelName;
	}
 
	public AssetCategories getAssetCategoriesId() {
		return assetCategoriesId;
	}
	public void setAssetCategoriesId(AssetCategories assetCategoriesId) {
		this.assetCategoriesId = assetCategoriesId;
	}
	public AssetModel(String modelName,boolean active) {
 		this.modelName = modelName;
		this.active=active;

	}
	public AssetModel() {}
	
}
