package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoUserSignup {
	
	// Fields
	DataSource dataSource;

	// Constructor
	public DaoUserSignup() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	// checkId
	public int checkId(String user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from user where user_id = ? and user_deletedate is null ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				check = resultSet.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;

	} // checkId
	
	// checkNick
	public int checkNick(String user_nick) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*) from user where user_nick = ? and user_deletedate is null ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_nick);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				check = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
		
	} // checkId
	
	// Sign up
	public void signupAction(String user_id, String user_name, String user_nick, String user_pw, String user_telno, String user_email, String user_birthday, String user_gender, String user_addresszipcode, String user_address1, String user_address2, String user_address3) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into user (user_id, user_name, user_nick, user_pw, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3, user_initdate) values (?,?,?,?,?,?,?,?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, user_nick);
			preparedStatement.setString(4, user_pw);
			preparedStatement.setString(5, user_telno);
			preparedStatement.setString(6, user_email);
			preparedStatement.setString(7, user_birthday);
			preparedStatement.setString(8, user_gender);
			preparedStatement.setString(9, user_addresszipcode);
			preparedStatement.setString(10, user_address1);
			preparedStatement.setString(11, user_address2);
			preparedStatement.setString(12, user_address3);
			
			preparedStatement.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // signupAction
	
	// Sign up
	public void signupApiAction(String user_id, String user_name, String user_nick, String user_telno, String user_email, String user_birthday, String user_gender, String user_addresszipcode, String user_address1, String user_address2, String user_address3) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into user (user_id, user_name, user_nick, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3, user_initdate) values (?,?,?,?,?,?,?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, user_nick);
			preparedStatement.setString(4, user_telno);
			preparedStatement.setString(5, user_email);
			preparedStatement.setString(6, user_birthday);
			preparedStatement.setString(7, user_gender);
			preparedStatement.setString(8, user_addresszipcode);
			preparedStatement.setString(9, user_address1);
			preparedStatement.setString(10, user_address2);
			preparedStatement.setString(11, user_address3);
			
			preparedStatement.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // signupApiAction
	
}
