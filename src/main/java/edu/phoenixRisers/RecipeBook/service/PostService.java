package edu.phoenixRisers.RecipeBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.phoenixRisers.RecipeBook.dao.Post;
import edu.phoenixRisers.RecipeBook.dao.PostDAO;
import edu.phoenixRisers.RecipeBook.dao.UserPost;


@Service
public class PostService {

	
	@Autowired
	private PostDAO postdao;
	
	public List getAllPosts() {
		
		List posts = new ArrayList<>();
		postdao.findAll().forEach(posts::add);
		return posts;
		
	}
	
	
	public Post getPost(UserPost userPost) {
		
		System.out.println("User ID" + userPost.getUserID());
		System.out.println("User ID" + userPost.getPostID());

		return postdao.findById(userPost).orElse(null);
		
	}
	

	public void addPost(Post post) {
		postdao.save(post);
	}
	

	
}
