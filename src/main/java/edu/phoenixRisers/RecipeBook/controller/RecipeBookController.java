package edu.phoenixRisers.RecipeBook.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public String recipesPage() {
		return "recipebook";
	}
	
	@RequestMapping(value = "/recipe/{postID}", method = RequestMethod.GET)
	public String recipe(@PathVariable int postID, Model model) {
		
     Post specificrecipe = postService.getSpecificRecipe(postID);
		model.addAttribute("specificrecipe", specificrecipe );
		return "recipe";
				
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser() {
		
		User userDetails = new User(); 
		userDetails.setFirstName("Thirumalai2");
		userDetails.setLastName("Doss3");
		userDetails.setUserName("ThiruDoss");
		userDetails.setBio("Cooking is My Hobbyy");
		userDetails.setEmail("abc322@gmail.com");
		userDetails.setPassword("12345");

		userService.addUser(userDetails);
		return "/";
				
	}
	
	

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getPostForAdmin(@RequestParam(value="postID", required=false) String postID,Model model, HttpServletRequest request) {
        
        System.out.println("Post ID " + postID);
//        System.out.println("In Posts " + postService.getAllPosts(model));
//        model.addAttribute("id", 2);
        List<Post> posts = postService.getAllPosts(model);
        List<User> users = userService.getAllUsers();
        
        model.addAttribute("postForAdmin", posts);
        model.addAttribute("usersForAdmin", users);
        System.out.println("In COntroller **************");
        return "admin";
    }

	
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List getAllUsers() {
		
		System.out.println("In All Users controller");
		System.out.println("User Details" + userService.getAllUsers());
		return userService.getAllUsers();
		
	}
	
	@RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
	public String getUser(@PathVariable int userID, Model model) {
		
		User userDetails = userService.getUserDetails(userID);
		model.addAttribute("userprofile", userDetails);
		
		System.out.println("CUST ID FROM DB " + userDetails.getUserName());
		
		return "userprofile";
		
	}
	
	
	
	
	
	
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
		System.out.println("From Form " + post.getSpecialDesc());
		System.out.println("From Form " + post.getTitle());
		
		
		
//		Post postDetails = new Post(); 
		UserPost up = new UserPost();
		post.setUserID(10);
		postService.addPost(post);
		
		return "addRecipe";
				
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllPosts(Model model, Principal principal) {
		
		
//		System.out.println("In Posts " + postService.getAllPosts(model));
		String email=principal.getName();
		
		User currentUser = userService.getUserByEmail(email);
		int userID = currentUser.getUserId();
		
		System.out.println("User ID " + currentUser.getUserId());
		System.out.println("First Name " + currentUser.getFirstName());
		
		model.addAttribute("id", userID);
		List<Post> posts = postService.getAllPosts(model);
		model.addAttribute("postList", posts);
		System.out.println("In COntroller **************");
		return "index";
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
		System.out.println("Usser ID is " + userID);
		List<Post> favPosts = favouriteServices.getMyFavourite(userID);
		
//		System.out.println("CUST ID FROM DB " + favPosts.get(1));
		model.addAttribute("postList", favPosts);
		return "postlist";
		

	}
	
	@RequestMapping(value = "/addToFavourite/{postID}")
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
	
	
	@RequestMapping(value = "/deletePost")
    public String  deletePost(@RequestParam(value="postID", required=false) int postID , Model model) {
        
        postService.deletePost(postID);
        System.out.println(postID + " Post Deleted SuccessFully");
        List<Post> posts = postService.getAllPosts(model);
        List<User> users = userService.getAllUsers();
        
        model.addAttribute("postForAdmin", posts);
        model.addAttribute("usersForAdmin", users);
            
        return "admin";
    }
	
	
	

}
