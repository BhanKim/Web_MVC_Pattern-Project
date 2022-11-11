package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoUser;

public class DaoUserInfo {

	// Fields
	DataSource dataSource;

	// Constructor
	public DaoUserInfo() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method

	// User pw 체크하기
	public int userPwCheck(String user_id, String user_pw) { // 아래에 int bId를 쓰려고 sbId를 썼음
		DtoUser dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*) from user where user_id = ? and user_pw = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_pw);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { // 한번 돌아가니까
				check = resultSet.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return check;
		
	}
	
	// User info 불러오기
	public DtoUser userInfoList(String suser_id) { // 아래에 int bId를 쓰려고 sbId를 썼음
		DtoUser dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from user where user_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, suser_id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { // 한번 돌아가니까
				String user_id = resultSet.getString("user_id"); // 아래에 칼럼 넣으면 위에 * 적어도 됨
				String user_nick = resultSet.getString("user_nick");
				String user_name = resultSet.getString("user_name");
				String user_pw = resultSet.getString("user_pw");
				String user_email = resultSet.getString("user_email");
				String user_telno = resultSet.getString("user_telno");
				String user_addresszipcode = resultSet.getString("user_addresszipcode");
				String user_address1 = resultSet.getString("user_address1");
				String user_address2 = resultSet.getString("user_address2");
				String user_address3 = resultSet.getString("user_address3");
				String user_birthday = resultSet.getString("user_birthday");
				String user_gender = resultSet.getString("user_gender");
				String user_initdate = resultSet.getString("user_initdate");
				
				dto = new DtoUser(user_id, user_nick, user_pw, user_email, user_name, user_address1, user_address2, user_address3, user_addresszipcode, user_birthday, user_gender, user_telno, user_initdate);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;

	}
	
	
	public void userInfoUpdate(String user_id, String user_nick, String user_telno, String user_email, String user_addresszipcode, String user_address1, String user_address2, String user_address3) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update user set user_nick = ?, user_telno = ?, user_email = ?, user_addresszipcode = ?, user_address1 = ?, user_address2 = ?, user_address3 = ?, user_updatedate = now() where user_id = '"+user_id+"'";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_nick);
			preparedStatement.setString(2, user_telno);
			preparedStatement.setString(3, user_email);
			preparedStatement.setString(4, user_addresszipcode);
			preparedStatement.setString(5, user_address1);
			preparedStatement.setString(6, user_address2);
			preparedStatement.setString(7, user_address3);
			
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
	}
	
}
