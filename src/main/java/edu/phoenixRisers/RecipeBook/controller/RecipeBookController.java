package edu.phoenixRisers.RecipeBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.phoenixRisers.RecipeBook.dao.Favourite;
import edu.phoenixRisers.RecipeBook.dao.Post;
import edu.phoenixRisers.RecipeBook.dao.User;
import edu.phoenixRisers.RecipeBook.dao.UserPost;
import edu.phoenixRisers.RecipeBook.service.FavouriteServices;
import edu.phoenixRisers.RecipeBook.service.PostService;
import edu.phoenixRisers.RecipeBook.service.UserService;

@RestController
public class RecipeBookController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser() {
		
		User userDetails = new User(); 
		userDetails.setFirstName("Thirumalai");
		userDetails.setLastName("Doss");
		userDetails.setUserName("ThiruDoss");
		userDetails.setBio("Cooking is My Hobbyy");
		userDetails.setEmail("abc@gmail.com");
		userDetails.setPassword("12345");

		userService.addUser(userDetails);
				
	}
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List getAllUsers() {
		
		System.out.println("In All Users controller");
		System.out.println("User Details" + userService.getAllUsers());
		return userService.getAllUsers();
		
	}
	
	@RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
	public User getCustomer(@PathVariable int userID) {
		
		User userDetails = userService.getUserDetails(userID);
		
		System.out.println("CUST ID FROM DB " + userDetails.getUserName());
		
		return userDetails;
		
	}
	
	
	
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public void addPost() {
		
		Post postDetails = new Post(); 
		UserPost up = new UserPost();
		up.setUserID(2);
		postDetails.setUserpost(up);
		postDetails.setCategory("Veg");
		postDetails.setCuisineType("Indian");
		postDetails.setTitle("Spicy Onion Rolls");
		postDetails.setShortDesc("Indian Flavoured Spicy onion rolls");
		postDetails.setPost("As whales go through their annual cycles of summer binge-eating and winter migrations, the wax in their ears changes from light to dark. These changes manifest as alternating bands, which you can see if you slice through the plugs. Much as with tree rings, you can count the bands to estimate a whale’s age. And you can also analyze them to measure the substances that were "
				+ "				coursing through the whale’s body when each band was formed. A whale’s earwax, then, is a chronological chemical biography.");
		postDetails.setIncredients("incredients");

		postService.addPost(postDetails);
				
	}
	
	@RequestMapping(value = "/getAllPosts", method = RequestMethod.GET)
	public List getAllPosts() {
		
		System.out.println("In Posts " + postService.getAllPosts());
		return postService.getAllPosts();
		
	}
	
	@RequestMapping(value = "/getPostByID/{userID}", method = RequestMethod.GET)
	public List<Post> getPostByID(@PathVariable int userID) {
		
		List<Post> postDetails = postService.getPostByUserID(userID);
		
		System.out.println("CUST ID FROM DB " + postDetails.get(1));
		
		return postDetails;
		
	}
	

	@RequestMapping(value = "/getPostByCategory/{Category}", method = RequestMethod.GET)
	public List<Post> getPostByID(@PathVariable String Category) {
		
		List<Post> postDetails = postService.getPostByCategory(Category);
		
		System.out.println("CUST ID FROM DB " + postDetails.get(1));
		
		return postDetails;
		
	}
	
	@RequestMapping(value = "/getPostByCuisine/{CuisineType}", method = RequestMethod.GET)
	public List<Post> getPostByCuisineType(@PathVariable String CuisineType) {
		
		List<Post> postDetails = postService.getPostByCuisineType(CuisineType);
		
		System.out.println("CUST ID FROM DB " + postDetails.get(1));
		
		return postDetails;
		
	}
	
	
	@Autowired
	FavouriteServices favouriteServices;
	
	@RequestMapping(value = "/myFavourite/{userID}", method = RequestMethod.GET)
	public List<Post> getPostMyFavourite(@PathVariable int userID) {
		
		List<Post> favPosts = favouriteServices.getMyFavourite(userID);
		
		System.out.println("CUST ID FROM DB " + favPosts.get(1));
		
		return favPosts;
		

	}
	
	@RequestMapping(value = "/addToFavourite/{userID}/{postID}", method = RequestMethod.POST)
	public void addToFavourite(@PathVariable int userID , @PathVariable int postID) {
		
		Favourite fav = new Favourite(); 
		fav.setPost_ID(postID);
		fav.setUser_ID(userID);
		
		favouriteServices.addFavourite(fav);
				
	}
	
	
	@RequestMapping(value = "/deletePost/{postID}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable int postID) {
		
		postService.deletePost(postID);
		System.out.println(postID + " Post Deleted SuccessFully");
				
	}
	
	

}
