package edu.phoenixRisers.RecipeBook.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAVOURITE")
public class Favourite {
	
	@Id
	@Column(name = "FAV_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fav_ID;
	
	@Column(name = "USER_ID")
	private int user_ID;
	
	@Column(name = "POST_ID")
	private int post_ID;
	
	
	public Favourite() {
		super();
	}
	
	

	public Favourite(int user_ID, int post_ID) {
		super();
		this.user_ID = user_ID;
		this.post_ID = post_ID;
	}

	
	public int getFav_ID() {
		return fav_ID;
	}

	public void setFav_ID(int fav_ID) {
		this.fav_ID = fav_ID;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public int getPost_ID() {
		return post_ID;
	}

	public void setPost_ID(int post_ID) {
		this.post_ID = post_ID;
	}

	
	
	
}
