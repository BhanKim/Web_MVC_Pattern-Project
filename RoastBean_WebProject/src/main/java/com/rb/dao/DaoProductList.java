package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoProductList;

public class DaoProductList {
	DataSource dataSource;

	public DaoProductList() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testproject");// 여기까지선언을 다 완료시켜주면 DB가 연결된 것
			// 위에 customer 공간에 스키마 이름을 작성해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DtoProductList> productList() {
		ArrayList<DtoProductList> dtos = new ArrayList<DtoProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;// 검색

		try {

			connection = dataSource.getConnection();
			String query = "select product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price from product where product_deletedate is null";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int product_id = resultSet.getInt("product_id");
				String product_name = resultSet.getString("product_name");
				String product_nation = resultSet.getString("product_nation");
				String product_image = resultSet.getString("product_image");
				String product_info = resultSet.getString("product_info");
				String product_stock = resultSet.getString("product_stock");
				String product_weight = resultSet.getString("product_weight");
				String product_price = resultSet.getString("product_price");

				DtoProductList dto = new DtoProductList(product_id, product_name, product_nation, product_image,
						product_info, product_stock, product_weight, product_price);
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

	public void delete(String product_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("product_delete.dao");
		try {
			connection = dataSource.getConnection();
			System.out.println("product_delete.dao_try");
			System.out.println(product_id);
			String query = "update product set product_deletedate = now() where product_id=?";
			

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product_id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int update(String product_name, String product_nation, String product_image,
			String product_info, String product_stock, String product_weight, String product_price, String sproduct_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;

		try {
			connection = dataSource.getConnection();

			String query = "update product set product_name = ?, product_nation = ?, product_image = ?, product_info = ?, product_stock = ?, product_weight = ?, product_price = ?, product_updatedate = now() where sproduct_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product_name);
			preparedStatement.setString(2, product_nation);
			preparedStatement.setString(3, product_image);
			preparedStatement.setString(4, product_info);
			preparedStatement.setString(5, product_stock);
			preparedStatement.setString(6, product_weight);
			preparedStatement.setString(7, product_price);
			preparedStatement.setString(8, sproduct_id);

			
			returnValue = preparedStatement.executeUpdate();
			
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
		return returnValue;

	}

	public void insert(String product_name, String product_nation, String product_image, String product_info,
			String product_stock, String product_weight, String product_price) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();

			String query = "insert into product (product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price, product_updatedate) values(?,?,?,?,?,?,?, now())";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, product_name);
			preparedStatement.setString(2, product_nation);
			preparedStatement.setString(3, product_image);
			preparedStatement.setString(4, product_info);
			preparedStatement.setString(5, product_stock);
			preparedStatement.setString(6, product_weight);
			preparedStatement.setString(7, product_price);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
