package edu.phoenixRisers.RecipeBook.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST")
public class Post {
	
//	@EmbeddedId
//	private UserPost userpost;
	
	@Column(name = "USER_ID")
	int userID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	int postID;
	
	@Column(name = "CATEGORY")
	String Category;
	
	@Column(name = "CUISINE_TYPE")
	String Cuisine;
	
	@Column(name = "TITLE")
	String Title;
	
	@Column(name = "SHORT_DESC")
	String shortDesc;
	
	@Column(name = "POST")
	String post;
	
	@Column(name = "INGREDIENTS")
	String incredients;

	
	public Post() {
		super();
	}

	public Post( String category, String cuisineType, String title, String shortDesc, String post,
			String incredients) {
		super();
	
		this.Category = category;
		this.Cuisine = cuisineType;
		this.Title = title;
		this.shortDesc = shortDesc;
		this.post = post;
		this.incredients = incredients;
	}
	

//	public UserPost getUserpost() {
//		return userpost;
//	}
//
//	public void setUserpost(UserPost userpost) {
//		this.userpost = userpost;
//	}

	
	
	public String getCategory() {
		return Category;
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

	public void setCategory(String category) {
		Category = category;
	}


	public String getCuisineType() {
		return Cuisine;
	}

	public void setCuisineType(String cuisineType) {
		Cuisine = cuisineType;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getIncredients() {
		return incredients;
	}

	public void setIncredients(String incredients) {
		this.incredients = incredients;
	}
	
	
	
	

}
