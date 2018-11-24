package edu.phoenixRisers.RecipeBook.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserDAO extends CrudRepository<User,Integer> {

	List<User> findAll();
	 
    Optional<User> findById(Integer userID);
    
    

}
