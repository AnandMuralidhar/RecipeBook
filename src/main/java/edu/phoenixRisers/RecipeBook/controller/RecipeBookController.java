package edu.phoenixRisers.RecipeBook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.phoenixRisers.RecipeBook.dao.Favourite;
import edu.phoenixRisers.RecipeBook.dao.Post;
import edu.phoenixRisers.RecipeBook.dao.User;
import edu.phoenixRisers.RecipeBook.dao.UserPost;
import edu.phoenixRisers.RecipeBook.service.FavouriteServices;
import edu.phoenixRisers.RecipeBook.service.PostService;
import edu.phoenixRisers.RecipeBook.service.UserService;

@Controller
public class RecipeBookController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser() {
		
		User userDetails = new User(); 
		userDetails.setFirstName("Thirumalai");
		userDetails.setLastName("Doss");
		userDetails.setUserName("ThiruDoss");
		userDetails.setBio("Cooking is My Hobbyy");
		userDetails.setEmail("abc3@gmail.com");
		userDetails.setPassword("12345");

		userService.addUser(userDetails);
		return "/";
				
	}
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List getAllUsers() {
		
		System.out.println("In All Users controller");
		System.out.println("User Details" + userService.getAllUsers());
		return userService.getAllUsers();
		
	}
	
	@RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
	public String getUser(@PathVariable int userID) {
		
		User userDetails = userService.getUserDetails(userID);
		
		System.out.println("CUST ID FROM DB " + userDetails.getUserName());
		
		return "userprofile";
		
	}
	
	
	
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String getAddPost(Model model) {
		System.out.println("In add post get controller");
		return "addRecipe";
	}

	
	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("AddPost") Post post, HttpServletRequest httprequests, Model model) {
		
		System.out.println("From Form " + post.getCategory());
		System.out.println("From Form " + post.getCuisineType());
		System.out.println("From Form " + post.getIncredients());
		System.out.println("From Form " + post.getPost());
		System.out.println("From Form " + post.getShortDesc());
		System.out.println("From Form " + post.getTitle());
		
		
		
//		Post postDetails = new Post(); 
		UserPost up = new UserPost();
		post.setUserID(10);
//		postDetails.setUserpost(up);
//		postDetails.setCategory("Veg");
//		postDetails.setCuisineType("Indian");
//		postDetails.setTitle("Spicy Onion Rolls");
//		postDetails.setShortDesc("Indian Flavoured Spicy onion rolls");
//		postDetails.setPost("As whales go through their annual cycles of summer binge-eating and winter migrations, the wax in their ears changes from light to dark. These changes manifest as alternating bands, which you can see if you slice through the plugs. Much as with tree rings, you can count the bands to estimate a whale’s age. And you can also analyze them to measure the substances that were "
//				+ "				coursing through the whale’s body when each band was formed. A whale’s earwax, then, is a chronological chemical biography.");
//		postDetails.setIncredients("incredients");

		postService.addPost(post);
		
		return "addRecipe";
				
	}
	
	@RequestMapping(value = "/getAllPost", method = RequestMethod.GET)
	public String getAllPosts(Model model) {
		
//		System.out.println("In Posts " + postService.getAllPosts(model));
		model.addAttribute("id", 2);
		List<Post> posts = postService.getAllPosts(model);
		model.addAttribute("postList", posts);
		System.out.println("In COntroller **************");
		return "postlist";
	}
	
	@RequestMapping(value = "/getPostByID/{userID}", method = RequestMethod.GET)
	public List<Post> getPostByID(@PathVariable int userID) {
		
		List<Post> postDetails = postService.getPostByUserID(userID);
		
//		System.out.println("CUST ID FROM DB " + postDetails.get(0).getCategory());
		
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
	
	@RequestMapping(value = "/myFavourite", method = RequestMethod.GET)
	public String getPostMyFavourite(Model model) {
		
		int userID=1;
		System.out.println("USer ID is " + userID);
		List<Post> favPosts = favouriteServices.getMyFavourite(userID);
		
//		System.out.println("CUST ID FROM DB " + favPosts.get(1));
		model.addAttribute("postList", favPosts);
		return "postlist";
		

	}
	
	@RequestMapping(value = "/addToFav/{postID}")
	public String addToFavourite( @PathVariable int postID, Model model) {
		
		int userID=2;
		System.out.println("USer ID is " + postID);
		System.out.println("USer ID is " + userID);
		Favourite fav = new Favourite(); 
		fav.setPost_ID(postID);
		fav.setUser_ID(userID);
		
		favouriteServices.addFavourite(fav);
//		String post = getAllPosts(model);
		List<Post> posts = postService.getAllPosts(model);
		model.addAttribute("postList", posts);
		return "postlist";
				
	}
	
	
	@RequestMapping(value = "/deletePost/{postID}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable int postID) {
		
		postService.deletePost(postID);
		System.out.println(postID + " Post Deleted SuccessFully");
				
	}
	
	

}
