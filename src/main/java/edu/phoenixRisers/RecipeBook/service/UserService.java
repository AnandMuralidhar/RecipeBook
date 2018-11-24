package edu.phoenixRisers.RecipeBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.phoenixRisers.RecipeBook.dao.User;
import edu.phoenixRisers.RecipeBook.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userdao;
	
	public List getAllUsers() {
		
		List userProfiles = new ArrayList<>();
		userdao.findAll().forEach(userProfiles::add);
		return userProfiles;
		
	}
	
	
	public User getUserDetails(int userID) {
		
		System.out.println("User ID" + userID);

		return userdao.findById(userID).orElse(null);
		
	}
	

	public void addUser(User userDetails) {
		userdao.save(userDetails);
	}
	
	
}
