package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoAdminLogin {
	DataSource dataSource;
	
	public DaoAdminLogin() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// loginCheckAdmin
	public int loginCheckAdmin(String admin_id, String admin_pw) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int check = 0;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from admin where admin_id = ? and admin_pw = ? ";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin_id);
			preparedStatement.setString(2, admin_pw);
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
		
	} // loginCheckAdmin

	
}
