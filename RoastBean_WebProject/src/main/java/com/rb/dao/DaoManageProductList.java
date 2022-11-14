package com.rb.dao;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
		System.out.println("ManageProductList.dao");
		try {

			connection = dataSource.getConnection();
			String query = "select p.product_id, p.product_name, p.product_nation, p.product_image, p.product_info, p.product_stock, p.product_weight, p.product_price, ";
			String query1 = "c.category_type, c.category_acidity, c.category_aroma, c.category_body, c.category_sweet ";
			String query2 = "from product as p, category as c ";
			String query3 = "where p.product_deletedate is null and p.product_id = c.product_id";
			preparedStatement = connection.prepareStatement(query + query1 + query2 + query3);
			resultSet = preparedStatement.executeQuery();

			System.out.println("ManageProductList.dao.try");

			while (resultSet.next()) {
				int product_id = resultSet.getInt("product_id");
				String product_name = resultSet.getString("product_name");
				String product_nation = resultSet.getString("product_nation");
				String product_image = resultSet.getString("product_image");
				String product_info = resultSet.getString("product_info");
				int product_stock = resultSet.getInt("product_stock");
				int product_weight = resultSet.getInt("product_weight");
				int product_price = resultSet.getInt("product_price");
				String category_type = resultSet.getString("category_type");
				String category_acidity = resultSet.getString("category_acidity");
				String category_aroma = resultSet.getString("category_aroma");
				String category_body = resultSet.getString("category_body");
				String category_sweet = resultSet.getString("category_sweet");

				DtoManageProductList dto = new DtoManageProductList(product_id, product_name, product_nation,
						product_image, product_info, product_stock, product_weight, product_price, category_type,
						category_acidity, category_aroma, category_body, category_sweet);
				dtos.add(dto);

				System.out.println("ManageProductList.dao.try.while");

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

	public ArrayList<DtoManageProductList> manageorderslistselete() {
		ArrayList<DtoManageProductList> dtos = new ArrayList<DtoManageProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;// 검색
		System.out.println("ManageOrdersList.dao");
		try {

			connection = dataSource.getConnection();
			String query = "select order_seq, user_id, product_id, order_name, order_address, "
					+ "order_email, order_telno, order_qty, order_price, order_date from orders";
			preparedStatement = connection.prepareStatement(query);

			System.out.println("query");

			resultSet = preparedStatement.executeQuery();

			System.out.println("ManageOrdersList.dao.try");

			while (resultSet.next()) {

				int order_seq = resultSet.getInt("order_seq");
				String user_id = resultSet.getString("user_id");
				int product_id = resultSet.getInt("product_id");
				String order_name = resultSet.getString("order_name");
				String order_address = resultSet.getString("order_address");
				String order_email = resultSet.getString("order_email");
				String order_telno = resultSet.getString("order_telno");
				int order_qty = resultSet.getInt("order_qty");
				int order_price = resultSet.getInt("order_price");
				Timestamp order_date = resultSet.getTimestamp("order_date");

				DtoManageProductList dto = new DtoManageProductList(order_seq, product_id, user_id, order_name,
						order_address, order_email, order_telno, order_qty, order_price, order_date);
				dtos.add(dto);

				System.out.println("ManageOrdersList.dao.try.while");

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

	}// manageorderslistselete

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
		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select max(product_id) as product_id from product ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);

			if (resultSet.next()) {
				result = resultSet.getInt("product_id");
				System.out.println(result);
			}

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

			String query = "select p.product_id, p.product_name, p.product_nation, p.product_image, p.product_info, p.product_stock, p.product_weight, p.product_price, "
					+ "c.category_type, c.category_acidity, c.category_aroma, c.category_body, c.category_sweet from product as p, category as c"
					+ " where p.product_id=?";
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

				String category_type = resultSet.getString("category_type");
				String category_acidity = resultSet.getString("category_acidity");
				String category_aroma = resultSet.getString("category_aroma");
				String category_body = resultSet.getString("category_body");
				String category_sweet = resultSet.getString("category_sweet");

				dto = new DtoManageProductList(product_id, product_name, product_nation, product_image, product_info,
						product_stock, product_weight, product_price, category_type, category_acidity, category_aroma,
						category_body, category_sweet);

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
			String product_info, int product_stock, int product_weight, int product_price, String category_type,
			String category_acidity, String category_body, String category_sweet, String category_aroma,
			int sproduct_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		try {
			connection = dataSource.getConnection();

			String query = "update product as p, category as c set "
					+ "p.product_name = ?, p.product_nation = ?, p.product_image = ?, p.product_info = ?, p.product_stock = ?, p.product_weight = ?, "
					+ "p.product_price = ?, p.product_updatedate = now(), "
					+ "c.category_type = ?, c.category_acidity = ?, c.category_body = ?, c.category_sweet = ?, c.category_aroma = ? "
					+ "where p.product_id = ? and c.product_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product_name);
			preparedStatement.setString(2, product_nation);
			preparedStatement.setString(3, product_image);
			preparedStatement.setString(4, product_info);
			preparedStatement.setInt(5, product_stock);
			preparedStatement.setInt(6, product_weight);
			preparedStatement.setInt(7, product_price);

			preparedStatement.setString(8, category_type);
			preparedStatement.setString(9, category_acidity);
			preparedStatement.setString(10, category_body);
			preparedStatement.setString(11, category_sweet);
			preparedStatement.setString(12, category_aroma);

			preparedStatement.setInt(13, sproduct_id);
			preparedStatement.setInt(14, sproduct_id);

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
//	public int manageptoductupdate1(String category_type, String category_acidity, String category_body, String category_sweet, String category_aroma, int sproduct_id) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		int returnValue = 0;
//		try {
//			connection = dataSource.getConnection();
//
//			String query = "update category set category_type = ?, category_acidity = ?, category_body = ?, category_sweet = ?, category_aroma, where product_id = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, category_type);
//			preparedStatement.setString(2, category_acidity);
//			preparedStatement.setString(3, category_body);
//			preparedStatement.setString(4, category_sweet);
//			preparedStatement.setString(5, category_aroma);
//			preparedStatement.setInt(6, sproduct_id);
//
//			System.out.println(category_type + "DaoUpdate");
//			returnValue = preparedStatement.executeUpdate();
//			System.out.println("query");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			try {
//				if (preparedStatement != null)
//					preparedStatement.close();
//				if (connection != null)
//					connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//		System.out.println(returnValue);
//		
//		
//		return returnValue;
//	}

	public ArrayList<DtoManageProductList> manageproductsearch(String queryname, String querycontent) {
		ArrayList<DtoManageProductList> dtos = new ArrayList<DtoManageProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("ManageProductSearch.dao");

		try {
			connection = dataSource.getConnection();
			String query = "select product_id, product_name, product_nation, product_image, product_info, product_stock, product_weight, product_price from product where "
					+ queryname + " like '%" + querycontent + "%' and product_deletedate is null";

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

	public ArrayList<DtoManageProductList> manageorderssearch(String queryname, String querycontent) {
		ArrayList<DtoManageProductList> dtos = new ArrayList<DtoManageProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("ManageProductSearch.dao");

		try {
			connection = dataSource.getConnection();
			String query = "select order_seq, user_id, product_id, order_name, order_address, order_email, "
					+ "order_telno, order_qty, order_price, order_date " + "from orders where " + queryname + " like '%"
					+ querycontent + "%'";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int order_seq = resultSet.getInt("order_seq");
				String user_id = resultSet.getString("user_id");
				int product_id = resultSet.getInt("product_id");

				String order_name = resultSet.getString("order_name");
				String order_address = resultSet.getString("order_address");
				String order_email = resultSet.getString("order_email");
				String order_telno = resultSet.getString("order_telno");

				int order_qty = resultSet.getInt("order_qty");
				int order_price = resultSet.getInt("order_price");
				Timestamp order_date = resultSet.getTimestamp("order_date");

				DtoManageProductList dto = new DtoManageProductList(order_seq, product_id, user_id, order_name,
						order_address, order_email, order_telno, order_qty, order_price, order_date);
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

	public int manageuserorderselect() {
		DtoManageProductList dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select sum(order_price) as order_date_sum from orders WHERE DATE_FORMAT (order_date, '%Y-%m-%d') = curdate()";
			// String query = "select sum(order_price) as order_date_sum from orders WHERE
			// DATE_FORMAT (order_date, '%Y-%m-%d') = '2022-11-13';";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("order_date_sum");
				System.out.println(result);
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
		return result;
	}

	// -----------------------------------------------
	public int manageuserprderrankingselect_max() {
		DtoManageProductList dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;

		try {
			connection = dataSource.getConnection();
			String query = "select o.product_id from orders as o group by o.product_id order by count(o.product_id) desc  limit 1;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);

			if (resultSet.next()) {
				result = resultSet.getInt("product_id");

				System.out.println(result);
			}

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
		System.out.println(result);
		return result;
	}

	// -----------------------------------------------
	// -----------------------------------------------
	public String manageuserprderrankingselect_max_name() {
		DtoManageProductList dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String result = null;

		try {
			connection = dataSource.getConnection();
			String query = "select p.product_name from product as p where p.product_id = (\n"
					+ "select o.product_id from orders as o group by o.product_id order by count(o.product_id) desc  limit 1);";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);

			if (resultSet.next()) {
				result = resultSet.getString("product_name");

				System.out.println(result);
			}

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
		System.out.println(result);
		return result;
	}

	public String manageuserprderrankingselect_max_img() {
		DtoManageProductList dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String result = null;

		try {
			connection = dataSource.getConnection();
			String query = "select p.product_image from product as p where p.product_id = (\n"
					+ "select o.product_id from orders as o group by o.product_id order by count(o.product_id) desc  limit 1);";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);

			if (resultSet.next()) {
				result = resultSet.getString("product_image");

				System.out.println(result);
			}

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
		System.out.println(result);
		return result;
	}

}
