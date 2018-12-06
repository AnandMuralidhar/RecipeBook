package edu.phoenixRisers.RecipeBook.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SpecificPostDAO extends CrudRepository<Post,Integer>{

	Optional<Post> findById(Integer postID);
}
