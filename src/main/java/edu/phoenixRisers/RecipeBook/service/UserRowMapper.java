package edu.phoenixRisers.RecipeBook.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.phoenixRisers.RecipeBook.dao.User;


public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(rowNum + " test test test test");
		User user = new User();
		user.setUserId(rs.getInt("USER_ID"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setUserName(rs.getString("USER_NAME"));
		user.setBio(rs.getString("BIO"));
		
		return user;
	}
}
