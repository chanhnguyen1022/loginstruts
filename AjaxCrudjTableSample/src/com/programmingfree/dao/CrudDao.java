package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.model.User;
import com.programmingfree.utility.DBUtility;
public class CrudDao {
	
	private Connection connection;

	public CrudDao() {
		connection = DBUtility.getConnection();
	}

	public void addUser(User user) {
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMER (USERID,CUSTOMERNAME,SEX,BIRTHDAY,ADDRESS) VALUES  (?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setInt(1, user.getUserid());
			preparedStatement.setString(2, user.getCustomerName());
			preparedStatement.setString(3, user.getSex());			
			preparedStatement.setString(4, user.getBirthDay());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM CUSTOMER WHERE USERID=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE CUSTOMER SET SEX=?,BIRTHDAY=?" +
							"WHERE USERID=?");
			// Parameters start with 1			
			preparedStatement.setString(1, user.getSex());
			preparedStatement.setString(2, user.getBirthDay());			
			preparedStatement.setInt(3, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setCustomerName(rs.getString("customerName"));
				user.setSex(rs.getString("sex"));				
				user.setBirthDay(rs.getString("birthDay"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM CUSTOMER WHERE USERID=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setCustomerName(rs.getString("customerName"));
				user.setSex(rs.getString("sex"));				
				user.setBirthDay(rs.getString("birthDay"));
				user.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
