package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoProductList;

public class DaoReview {
	
	// Fields
		DataSource dataSource;
		
		// Constructor
		public DaoReview() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void insertReview(String user_id, int order_seq, int product_id, String review_content, int review_star) {

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = dataSource.getConnection();
				String query1 = "insert into review (review_date, review_content, review_star, order_seq, product_id, user_id) ";
				String query2 = "value (now(), ?, ?, ?, ?, ?)";
				
				preparedStatement = connection.prepareStatement(query1 + query2);
				preparedStatement.setString(1, review_content);
				preparedStatement.setInt(2, review_star);
				preparedStatement.setInt(3, order_seq);
				preparedStatement.setInt(4, product_id);
				preparedStatement.setString(5, user_id);
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
		
		public DtoProductList listReview(int oorder_seq) {
	        DtoProductList dtos = null;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            
	            connection = dataSource.getConnection();

	            String query1 = "select o.order_seq, o.product_id, o.order_qty, p.product_name, p.product_weight, o.order_price, p.product_image ";
	            String query2 = "from product as p, orders as o where o.product_id = p.product_id and order_seq = " + oorder_seq;
	            
	            preparedStatement = connection.prepareStatement(query1 + query2);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	int order_seq = resultSet.getInt("o.order_seq");
	            	int product_id = resultSet.getInt("o.product_id");
	                int order_qty = resultSet.getInt("o.order_qty");
	                String product_name = resultSet.getString("p.product_name");
	                int product_weight = resultSet.getInt("p.product_weight");
	                int order_price = resultSet.getInt("o.order_price");
	                String product_image = resultSet.getString("p.product_image");

	                dtos = new DtoProductList(product_id, product_name, product_weight, product_image, order_seq, order_qty, order_price);
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
		
		public void reviewDelete(int review_seq) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = dataSource.getConnection();

				String query = "delete from review where review_seq = ?";
				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, review_seq);

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
