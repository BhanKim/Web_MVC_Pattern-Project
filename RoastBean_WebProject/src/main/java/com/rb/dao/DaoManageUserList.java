package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoManageUserList;

public class DaoManageUserList {
	DataSource dataSource;
	
	public DaoManageUserList() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean"); //수정 필수 부분
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<DtoManageUserList>manageuserlist(){
		ArrayList<DtoManageUserList> dtos = new ArrayList<DtoManageUserList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "select user_id, user_pw, user_name, user_birthday, user_gender, user_email, user_telno from user";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String user_id = resultSet.getString("user_id");
				String user_pw = resultSet.getString("user_pw");
				String user_name = resultSet.getString("user_name");
				String user_birthday = resultSet.getString("user_birthday");
				String user_gender = resultSet.getString("user_gender");
				String user_email = resultSet.getString("user_email");
				String user_telno = resultSet.getString("user_telno");
				
				System.out.println(user_id);
				System.out.println(user_telno);
				System.out.println("query");
				
				DtoManageUserList dto = new DtoManageUserList(user_id, user_pw, user_name, user_birthday, user_gender, user_email,
						user_telno);
				dtos.add(dto);
			}
		}
		catch (Exception e) {
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
		return dtos;
	}//manageuserlist
	
}
