package com.ViewWiser.security.dataBaseModel;

 
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ViewWiser.security.AssetUser;
/*** This table will create AssetLinkTable in database, 
 * it helps to allocate the Asset to Users by providing the AssetId ,UserId,issueDate **/
@Entity
@Table(name="AssetLinkTable")
public class AssetAddAndRemoveTable
{
@Id/** to make field as primary key**/
@GeneratedValue(strategy = GenerationType.IDENTITY)/** make as Auto increment**/
private int id;
@Column
 private LocalDate issueDate;
@Column
private LocalDate returnDate;
/** one to one with AssetUser**/
@OneToOne
private AssetUser userId;
/** Many to one relation with Asset Table**/
@ManyToOne
@JoinColumn(name="AssetID")/** helps to add column in the existing table**/
private AssetManagement AssetId;

/** All About Getters and Setters**/
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public AssetUser getUserId() {
	return userId;
}
public void setUserId(AssetUser userId) {
	this.userId = userId;
}
public AssetManagement getAssetId() {
	return AssetId;
}
public void setAssetId(AssetManagement assetId) {
	AssetId = assetId;
}
public LocalDate getIssueDate() {
	return issueDate;
}
public void setIssueDate(LocalDate issueDate) {
	this.issueDate = issueDate;
}
public LocalDate getReturnDate() {
	return returnDate;
}
public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
}
public AssetAddAndRemoveTable(LocalDate issueDate) {
 	this.issueDate = issueDate;
}
 public AssetAddAndRemoveTable() {}



}
