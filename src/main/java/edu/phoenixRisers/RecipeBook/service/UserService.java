package edu.phoenixRisers.RecipeBook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import edu.phoenixRisers.RecipeBook.dao.User;
import edu.phoenixRisers.RecipeBook.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Autowired
	private UserDAO userdao;
	
	public List getAllUsers() {
		
		List userProfiles = new ArrayList<>();
		userdao.findAll().forEach(userProfiles::add);
		return userProfiles;

	}
	
	public List getUserByEmail() {
		
		List userProfiles = new ArrayList<>();
		userdao.findAll().forEach(userProfiles::add);
		
		
		
		return userProfiles;

	}
	
	
	public User getUserDetails(int userID) {
		
		System.out.println("User ID" + userID);

		return userdao.findById(userID).orElse(null);
		
	}
	

	public void updateUser(User userDetails) {
		
		
		Connection connection = null;
		System.out.println("Add User Update Control" + userDetails.getUserId());
		System.out.println(userDetails.getFirstName());
		System.out.println(userDetails.getLastName());
		
		String UPDT_SQL = "UPDATE USER SET FIRST_NAME = ?, LAST_NAME = ?, USER_NAME = ? , BIO = ? where USER_ID=?";
		
		try{
		connection = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(UPDT_SQL);
		preparedstatement.setString(1, userDetails.getFirstName());
		preparedstatement.setString(2, userDetails.getLastName());
		preparedstatement.setString(3, userDetails.getUserName());
		preparedstatement.setString(4, userDetails.getBio());
		preparedstatement.setInt(5, userDetails.getUserId());
		preparedstatement.executeUpdate();
		preparedstatement.close();
		}catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            if (connection != null) {
                try {
                	connection.close();
                } catch (SQLException e) {}

            }
        }
		

		
		
		
		
	}
	
	
	public User getUserByEmail(String email) {
		/*System.out.println("Booking ID " + BookingID);
		return tableReservationDAO.findById(restID).orElse(null);*/
		
	
		User user = new User();
		
		System.out.println("UserID ...." + email);
//		User UserList= new User();
		Connection connection = null;
		
		try {
		
		String SELECT_SQL = "SELECT * FROM USER where EMAIL = ? ";

		System.out.println("Inside Try method");
		user = jdbcTemplate.queryForObject(SELECT_SQL, new UserRowMapper(), email);
		
		
		System.out.println("Inside Try method");
		
		
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
		
		return user;

	}
	
	
}
