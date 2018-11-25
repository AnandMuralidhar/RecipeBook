package edu.phoenixRisers.RecipeBook.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

import edu.phoenixRisers.RecipeBook.dao.Post;

public class PostRowMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(rowNum + " test test test test");
		Post post = new Post();
		HashMap<Integer,Post> mapRet= new HashMap<Integer,Post>();
		while(rs.next()) {
		
		post.setCategory(rs.getString("CATEGORY"));
		post.setCuisineType(rs.getString("CUISINE_TYPE"));
		post.setTitle(rs.getString("TITLE"));
		post.setShortDesc(rs.getString("SHORT_DESC"));
		post.setPost(rs.getString("POST"));
		post.setIncredients(rs.getString("INGREDIENTS"));
		System.out.println("Fetching Each Post frm Post Table for User ID");
		mapRet.put(rowNum, post);
		}
		
		return post;
	}	


}
