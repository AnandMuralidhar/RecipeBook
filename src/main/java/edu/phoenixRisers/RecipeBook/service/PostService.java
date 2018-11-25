package edu.phoenixRisers.RecipeBook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.phoenixRisers.RecipeBook.dao.Post;
import edu.phoenixRisers.RecipeBook.dao.PostDAO;
import edu.phoenixRisers.RecipeBook.dao.UserPost;


@Repository
public class PostService {

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PostDAO postdao;
	
	
	//----------------Post----------------------//
	public void addPost(Post post) {
		postdao.save(post);
	}
	
	public void deletePost(int postID) {
		
		System.out.println("User ID" + postID);
		Connection connection = null;

		try {
		
		String DELET_SQL = "DELETE FROM POST where POST_ID = ?";
		
		connection = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(DELET_SQL);
		preparedstatement.setInt(1, postID);
		preparedstatement.executeUpdate();
		preparedstatement.close();
		
		System.out.println("Post ID " + postID +"Deleted Successfully");

		}catch (Exception e) {

            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                	connection.close();
                } catch (SQLException e) {}

            }
        }	

	}
	
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
	
	public List<Post> getPostByUserID(int userID) {
		
		System.out.println("User ID" + userID);
		List<Post> postList= new ArrayList<Post>();
		Connection connection = null;
		
		try {
		
		String SELECT_SQL = "SELECT * FROM POST where USER_ID = ?";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_SQL, userID);
		System.out.println("Title  -----");
		
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
                } catch (SQLException e) {}

            }
        }	
		
		return postList;
		
	}
	
public List<Post> getPostByCategory(String Category) {
		
		System.out.println("Category" + Category);
		List<Post> postList= new ArrayList<Post>();
		Connection connection = null;
		
		try {
		
		String SELECT_SQL = "SELECT * FROM POST where CATEGORY = ?";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_SQL, Category);
		System.out.println("Title  -----");
		
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
                } catch (SQLException e) {}

            }
        }	
		
		return postList;
		
	}


public List<Post> getPostByCuisineType(String CuisineType) {
	
	System.out.println("CuisineType" + CuisineType);
	List<Post> postList= new ArrayList<Post>();
	Connection connection = null;
	
	try {
	
	String SELECT_SQL = "SELECT * FROM POST where CUISINE_TYPE = ?";
	
	List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_SQL, CuisineType);
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
            } catch (SQLException e) {}

        }
    }	
	
	return postList;
	
}

	

	
	
	
}
