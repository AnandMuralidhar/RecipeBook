package edu.phoenixRisers.RecipeBook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.phoenixRisers.RecipeBook.dao.Favourite;
import edu.phoenixRisers.RecipeBook.dao.FavouriteDAO;
import edu.phoenixRisers.RecipeBook.dao.Post;

@Repository
public class FavouriteServices {
	

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FavouriteDAO favouriteDAO;
	
	
	public void addFavourite(Favourite favourite) {
		favouriteDAO.save(favourite);
//		postdao.save(post);
	}
	
	
	public List<Post> getMyFavourite(int userID) {
		
		System.out.println("UserID" + userID);
		List<Post> postList= new ArrayList<Post>();
		Connection connection = null;
		
		try {
		
		String SELECT_SQL = "SELECT * FROM POST where POST_ID IN (SELECT POST_ID FROM FAVOURITE where USER_ID = ?)";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_SQL, userID);
		System.out.println("Title  -----" );
		
			for(Map posts: rows) {
				Post post = new Post();
				post.setCategory((String)posts.get("CATEGORY"));
				post.setCuisineType((String)posts.get("CUISINE_TYPE"));
				post.setTitle((String)posts.get("TITLE"));
				post.setShortDesc((String)posts.get("SHORT_DESC"));
				post.setPost((String)posts.get("POST"));
				post.setIncredients((String)posts.get("INGREDIENTS"));
				postList.add(post);
			}
		}catch (Exception e) {

	        throw new RuntimeException(e);

	    } finally {
	        if (connection != null) {
	            try {
	            	connection.close();
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            }

	        }
	    }	
		
		return postList;
		
	}

	
}
