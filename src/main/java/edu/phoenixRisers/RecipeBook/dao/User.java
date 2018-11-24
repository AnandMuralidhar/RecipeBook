package edu.phoenixRisers.RecipeBook.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	int userID;
	
	@Column(name = "FIRST_NAME")
	String firstName;
	
	
	@Column(name = "LAST_NAME")
	String lastName;
	
	
	@Column(name = "EMAIL")
	String email;
	
	@Column(name = "USER_NAME")
	String userName;
	
	@Column(name = "PASSWORD")
	String password;
	
	@Column(name = "BIO")
	String bio;
	
	
	
	public User() {
		super();

	}
	

	public User(String firstName, String lastName, String email, String userName, String password, String bio) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.bio = bio;
	}

	public int getUserId() {
		return userID;
	}

	public void setUserId(int userId) {
		this.userID = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
