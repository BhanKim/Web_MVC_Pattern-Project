package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoManageProductList;

public class DaoManageProductList {
	DataSource dataSource;

	public DaoManageProductList() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testproject");// 여기까지선언을 다 완료시켜주면 DB가 연결된 것
			// 위에 customer 공간에 스키마 이름을 작성해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DtoManageProductList> manageproductlist() {
		ArrayList<DtoManageProductList> dtos = new ArrayList<DtoManageProductList>();
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

				DtoManageProductList dto = new DtoManageProductList(product_id, product_name, product_nation,
						product_image, product_info, product_stock, product_weight, product_price);
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

	} // ManageProductList

	public void manageproductinsert(String product_name, String product_nation, String product_image,
			String product_info, String product_stock, String product_weight, String product_price) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = dataSource.getConnection();

			String query = "insert into product (product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price, product_initdate) values(?,?,?,?,?,?,?, now())";
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

	public void manageproductdelete(String product_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("manageproductdelete.dao");
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

	public DtoManageProductList manageptoductupdateselect(String sproduct_id) {
		DtoManageProductList dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("dao의 seen");

		try {
			connection = dataSource.getConnection();

			String query = "select product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price from product where product_id=?";
			System.out.println("select_query");
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sproduct_id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int product_id = resultSet.getInt("product_id");
				String product_name = resultSet.getString("product_name");
				String product_nation = resultSet.getString("product_nation");
				String product_image = resultSet.getString("product_image");
				String product_info = resultSet.getString("product_info");
				String product_stock = resultSet.getString("product_stock");
				String product_weight = resultSet.getString("product_weight");
				String product_price = resultSet.getString("product_price");
			
			dto = new DtoManageProductList(product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price);
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
		return dto;
	}
	public int manageptoductupdate(String product_name, String product_nation, String product_image, String product_info,
			String product_stock, String product_weight, String product_price, String sproduct_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		try {
			connection = dataSource.getConnection();

			String query = "update product set product_name = ?, product_nation = ?,  product_info = ?, product_stock = ?, product_weight = ?, product_price = ?, product_updatedate = now() where product_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product_name);
			preparedStatement.setString(2, product_nation);
			// preparedStatement.setString(3, product_image);
			preparedStatement.setString(3, product_info);
			preparedStatement.setString(4, product_stock);
			preparedStatement.setString(5, product_weight);
			preparedStatement.setString(6, product_price);
			preparedStatement.setString(7, sproduct_id);

			System.out.println(sproduct_id + "DaoUpdate");
			returnValue = preparedStatement.executeUpdate();
			System.out.println("query");

			
		}catch (Exception e) {
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
		System.out.println(returnValue);
		return returnValue;
		
	}
	public ArrayList<DtoManageProductList>manageproductsearch(String queryname, String querycontent){
		ArrayList<DtoManageProductList> dtos = new ArrayList<DtoManageProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("ManageProductSearch.dao");

		try {
			connection = dataSource.getConnection();
			String query = "select product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price from product where " + queryname + " like '%" + querycontent + "%'";
			
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

				DtoManageProductList dto = new DtoManageProductList(product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price);
				dtos.add(dto);
				
				System.out.println("ManageProductSearch.dao_try");
			}
			
		}catch (Exception e) {
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
}
