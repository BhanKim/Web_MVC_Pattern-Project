package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoOrder {

	DataSource dataSource;

	public DaoOrder() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertOrder(String user_id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query1 = "insert into orders (product_id, user_id, order_qty, order_price, order_date) ";
			String query2 = "select p.product_id, ?, sum(c.cart_qty), (p.product_price * sum(c.cart_qty)), now() ";
			String query3 = "from product as p, cart as c ";
			String query4 = "where p.product_id = c.product_id and c.user_id = ? ";
			String query5 = "group by p.product_id, p.product_name, p.product_price, c.cart_qty";
			
			preparedStatement = connection.prepareStatement(query1 + query2 + query3 + query4 + query5);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, user_id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // order table insert
	
	public void insertOrderUserInfo(String order_telno, String order_zipcode, String order_address1, String order_address2, String order_address3, String order_email, String order_name, String user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "update orders set order_telno = ?, order_zipcode = ?, order_address1 = ?, order_address2 = ?, order_address3 = ?, order_email = ?, order_name = ? ";
			String query2 = "where user_id = ? and order_zipcode is null";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			preparedStatement.setString(1, order_telno);
			preparedStatement.setString(2, order_zipcode);
			preparedStatement.setString(3, order_address1);
			preparedStatement.setString(4, order_address2);
			preparedStatement.setString(5, order_address3);
			preparedStatement.setString(6, order_email);
			preparedStatement.setString(7, order_name);
			preparedStatement.setString(8, user_id);
			
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
	
	public void deleteCart(String user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();

			String query = "delete from cart where user_id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user_id);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
