package edu.phoenixRisers.RecipeBook.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PostDAO extends CrudRepository<Post ,UserPost> {

	List<Post> findAll();
	 
    Optional<Post> findById(UserPost userPost);
    
//    public abstract Post getPostByUserID(int userID);

}