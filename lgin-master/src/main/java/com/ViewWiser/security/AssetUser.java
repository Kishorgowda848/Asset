package com.ViewWiser.security;

 
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

/** this is the code to create login user table */
@Entity
public class AssetUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "userName")
	@Email
	private String userName;
	@Column(name = "Password")
	private String pass;
	@Column(name = "Role")
	private String role;
	@Column(name = "Active")
	private Boolean active;
	@Column(name = "token")
	private String token;
    
 
	 
	public AssetUser() {
	}

 
	public AssetUser(String userName, String pass, String role, Boolean active) {
		this.userName = userName;
		this.pass = pass;
		this.role = role;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
