package edu.phoenixRisers.RecipeBook.dao;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "POST")
public class Post {
	
	@EmbeddedId
	private UserPost userpost;
	
	@Column(name = "CATEGORY")
	String Category;
	
	@Column(name = "CUISINE_TYPE")
	String CuisineType;
	
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
		this.CuisineType = cuisineType;
		this.Title = title;
		this.shortDesc = shortDesc;
		this.post = post;
		this.incredients = incredients;
	}
	

	public UserPost getUserpost() {
		return userpost;
	}

	public void setUserpost(UserPost userpost) {
		this.userpost = userpost;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getCuisineType() {
		return CuisineType;
	}

	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
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
