package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.rb.dto.DtoCartList;

public class DaoCart {
	DataSource dataSource;

	public DaoCart() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void insertCart(int product_id, String user_id, int cart_qty) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();

			String query = "insert into cart (product_id, user_id, cart_qty, cart_date) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product_id);
			preparedStatement.setString(2, user_id);
			preparedStatement.setInt(3, cart_qty);

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
	} // cart table insert

	public ArrayList<DtoCartList> cartlist(String uuser_id) {
		ArrayList<DtoCartList> dtos = new ArrayList<DtoCartList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select u.user_id, p.product_id, sum(c.cart_qty), p.product_name, sum(p.product_price), p.product_price, p.product_weight, p.product_image ";
			String query2 = "from product as p, user as u, cart as c ";
			String query3 = "where p.product_id = c.product_id and c.user_id = u.user_id and u.user_id = '" + uuser_id + "'";
			String query4 = "group by u.user_id, p.product_id, p.product_name, p.product_price, p.product_weight, p.product_image";

			preparedStatement = connection.prepareStatement(query1 + query2 + query3 + query4);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String user_id = resultSet.getString("u.user_id");
				int product_id = resultSet.getInt("p.product_id");
				int cart_qty = resultSet.getInt("sum(c.cart_qty)");
				String product_name = resultSet.getString("p.product_name");
				int product_price = resultSet.getInt("p.product_price");
				int product_weight = resultSet.getInt("p.product_weight");
				int product_priceSum = resultSet.getInt("sum(p.product_price)");
				String product_image = resultSet.getString("p.product_image");

				DtoCartList dto = new DtoCartList(user_id, product_id, cart_qty, product_name, product_price, product_weight, product_priceSum, product_image);
				dtos.add(dto);
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
		return dtos;
	}

	public void cartDelete(int product_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();

			String query = "delete from cart where product_id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, product_id);

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

} // End
