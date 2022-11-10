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
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 검색
	public ArrayList<DtoProductList> list(int curPage, String category_type) {
		ArrayList<DtoProductList> dtos = new ArrayList<DtoProductList>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		if(category_type == null) {
			category_type = "%";
		}
		System.out.println(category_type);
		int totalCount = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) as total from product as p, category as c where p.product_id = c.product_id and c.category_type like '" + category_type + "'";
			// 총 게시물의 수를 구해주고 이걸 페이지마다 나눠서 보여주는 역할을 함
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCount = resultSet.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();// 게시물의 수가 null이 아닌경우 쿼리문 닫아줌
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(totalCount);
		int nEnd = (totalCount-(curPage-1)*9);
	    int nStart = (nEnd-8);
		try {
			connection = dataSource.getConnection();

			String query1 = "select * from ( select row_number() over(order by product_id) ";
			String query2 = "as rownum, p.product_id, p.product_name, p.product_weight, p.product_info, p.product_price, p.product_stock, p.product_image, c.category_type, c.category_acidity, c.category_aroma, c.category_body, c.category_sweet ";
			String query3 = "from product as p, category as c ";
			String query4 = "where p.product_id = c.product_id and c.category_type like ?) A ";
			String query5 = "where rownum <= ? and rownum >= ?";
			preparedStatement = connection.prepareStatement(query1 + query2 + query3 + query4 + query5);
			
			preparedStatement.setString(1, category_type);
			preparedStatement.setInt(2, nEnd);//끝나는 범위를 먼저
			preparedStatement.setInt(3, nStart);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String rownum = resultSet.getString("rownum");
				int product_id = resultSet.getInt("product_id");
				String product_name = resultSet.getString("product_name");
				int product_weight = resultSet.getInt("product_weight");
				String product_info = resultSet.getString("product_info");
				int product_price = resultSet.getInt("product_price");
				int product_stock = resultSet.getInt("product_stock");
				String product_image = resultSet.getString("product_image");
				String ccategory_type = resultSet.getString("category_type");
				String category_acidity = resultSet.getString("category_acidity");
				String category_aroma = resultSet.getString("category_aroma");
				String category_body = resultSet.getString("category_body");
				String category_sweet = resultSet.getString("category_sweet");

				DtoProductList dto = new DtoProductList(product_id, product_name, product_weight, product_info,
						product_price, product_stock, product_image, ccategory_type, category_acidity, category_aroma, category_body, category_sweet);
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

	// total 게시글 페이징
	public PageInfo articlePageProduct(int curPage, String category_type) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		int listCount = 9; // 한 페이지당 보여줄 게시물의 수
		int pageCount = 5; // 하단에 보여줄 페이지 리스트의 수
		
		if(category_type == null) {
			category_type = "%";
		}

		// 총 게시물의 수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();

			String query = "select count(*) as total from product as p, category as c where p.product_id = c.product_id and c.category_type like '" + category_type + "'";
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				totalCount = resultSet.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 총 페이지 수	
		int totalPage = totalCount / listCount;
		if (totalCount % listCount > 0)
			totalPage++;

		// 현재 페이지
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;

		// 시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;

		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		PageInfo pinfo = new PageInfo();
		pinfo.setTotalCount(totalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(curPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}

}