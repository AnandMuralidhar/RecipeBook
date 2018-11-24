package edu.phoenixRisers.RecipeBook.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class UserPost implements Serializable {
	
	@Column(name = "USER_ID")
	int userID;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	int postID;
	
	
	
	public UserPost() {
		super();
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	
	
}
