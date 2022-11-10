package com.rb.dao;

import java.security.KeyStore.ProtectionParameter;
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
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");// 여기까지선언을 다 완료시켜주면 DB가 연결된 것
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
				int product_stock = resultSet.getInt("product_stock");
				int product_weight = resultSet.getInt("product_weight");
				int product_price = resultSet.getInt("product_price");

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

	public void manageproductinsert(String first_product_name, String first_product_nation, String first_product_image,
			String first_product_info, String first_product_stock, String first_product_weight,
			String first_product_price) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
System.out.println(first_product_name);
		try {
			System.out.println("manageproductinsert.dao");
			connection = dataSource.getConnection();

			String query = "insert into product (product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price, product_initdate) values(?,?,?,?,?,?,?, now())";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, first_product_name);
			preparedStatement.setString(2, first_product_nation);
			preparedStatement.setString(3, first_product_image);
			preparedStatement.setString(4, first_product_info);
			preparedStatement.setString(5, first_product_stock);
			preparedStatement.setString(6, first_product_weight);
			preparedStatement.setString(7, first_product_price);

			preparedStatement.executeUpdate();
			System.out.println("manageproductinsert.doa");

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

	public int manageproductinsertselect() {
		DtoManageProductList dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result=0;
		try {
			connection = dataSource.getConnection();
			String query = "select max(product_id) as product_id from product ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);
			
			if(resultSet.next()) {
				result = resultSet.getInt("product_id");
				System.out.println(result);
			}
			
		}catch (Exception e) {
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
		System.out.println(result);
		return result;
	}

	public void manageproductinsert1(String category_type, String category_acidity, String category_body,
			String category_sweet, String category_aroma, int product_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into category (category_type, category_acidity, category_body, category_sweet, category_aroma, product_id) values(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, category_type);
			preparedStatement.setString(2, category_acidity);
			preparedStatement.setString(3, category_body);
			preparedStatement.setString(4, category_sweet);
			preparedStatement.setString(5, category_aroma);
			preparedStatement.setInt(6, product_id);

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

	public void manageproductdelete(int product_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println("manageproductdelete.dao");
		try {
			connection = dataSource.getConnection();
			System.out.println("product_delete.dao_try");
			System.out.println(product_id);
			String query = "update product set product_deletedate = now() where product_id=?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, product_id);

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

	public DtoManageProductList manageptoductupdateselect(int sproduct_id) {
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
			preparedStatement.setInt(1, sproduct_id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int product_id = resultSet.getInt("product_id");
				String product_name = resultSet.getString("product_name");
				String product_nation = resultSet.getString("product_nation");
				String product_image = resultSet.getString("product_image");
				String product_info = resultSet.getString("product_info");
				int product_stock = resultSet.getInt("product_stock");
				int product_weight = resultSet.getInt("product_weight");
				int product_price = resultSet.getInt("product_price");

				dto = new DtoManageProductList(product_id, product_name, product_nation, product_image, product_info,
						product_stock, product_weight, product_price);
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

	public int manageptoductupdate(String product_name, String product_nation, String product_image,
			String product_info, int product_stock, int product_weight, int product_price, int sproduct_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		try {
			connection = dataSource.getConnection();

			String query = "update product set product_name = ?, product_nation = ?, product_image = ?, product_info = ?, product_stock = ?, product_weight = ?, product_price = ?, product_updatedate = now() where product_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product_name);
			preparedStatement.setString(2, product_nation);
			preparedStatement.setString(3, product_image);
			preparedStatement.setString(4, product_info);
			preparedStatement.setInt(5, product_stock);
			preparedStatement.setInt(6, product_weight);
			preparedStatement.setInt(7, product_price);
			preparedStatement.setInt(8, sproduct_id);

			System.out.println(sproduct_id + "DaoUpdate");
			returnValue = preparedStatement.executeUpdate();
			System.out.println("query");

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
		System.out.println(returnValue);
		return returnValue;

	}

	public ArrayList<DtoManageProductList> manageproductsearch(String queryname, String querycontent) {
		ArrayList<DtoManageProductList> dtos = new ArrayList<DtoManageProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("ManageProductSearch.dao");

		try {
			connection = dataSource.getConnection();
			String query = "select product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price from product where "
					+ queryname + " like '%" + querycontent + "%'";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int product_id = resultSet.getInt("product_id");
				String product_name = resultSet.getString("product_name");
				String product_nation = resultSet.getString("product_nation");
				String product_image = resultSet.getString("product_image");
				String product_info = resultSet.getString("product_info");
				int product_stock = resultSet.getInt("product_stock");
				int product_weight = resultSet.getInt("product_weight");
				int product_price = resultSet.getInt("product_price");

				DtoManageProductList dto = new DtoManageProductList(product_id, product_name, product_nation,
						product_image, product_info, product_stock, product_weight, product_price);
				dtos.add(dto);

				System.out.println("ManageProductSearch.dao_try");
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
}
