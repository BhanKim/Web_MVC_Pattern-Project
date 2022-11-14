package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoProductList;
import com.rb.dto.DtoReview;

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
		
		public DtoReview listMyReviewEdit(int rreview_seq) {
			DtoReview dtos = null;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            
	            connection = dataSource.getConnection();

	            String query1 = "select review_seq, order_seq, review_content, review_star ";
	            String query2 = "from review where review_seq = " + rreview_seq;
	            
	            preparedStatement = connection.prepareStatement(query1 + query2);
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	int review_seq = resultSet.getInt("review_seq");
	            	int order_seq = resultSet.getInt("order_seq");
	            	String review_content = resultSet.getString("review_content");
	                int review_star = resultSet.getInt("review_star");
	                

	                dtos = new DtoReview(review_seq, review_content, order_seq, review_star);
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
		
		public void reviewUpdate(String review_content, int review_star, int review_seq) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = dataSource.getConnection();

				String query = "update review set review_content = ?, review_star = ? where review_seq = ?";
				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, review_content);
				preparedStatement.setInt(2, review_star);
				preparedStatement.setInt(3, review_seq);

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
		
		public ArrayList<DtoReview> reviewMyList(String user_id, int curPage) {
	    	ArrayList<DtoReview> dtos = new ArrayList<DtoReview>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			int totalCount = 0;
			try {
				connection = dataSource.getConnection();
				String query = "select count(*) as total from review where user_id = '" + user_id + "'";
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
			
			int nEnd = (totalCount - (curPage - 1) * 10);
			int nStart = (nEnd - 9);

	        try {
	            
	            connection = dataSource.getConnection();

	            String query1 = "select * from (select row_number() over(order by review_seq asc) ";
	            String query2 = "as rownum, r.review_seq, r.review_content, u.user_nick, r.review_date, r.review_star, r.order_seq ";
	            String query3 = "from review as r, user as u where r.user_id = u.user_id and r.user_id = ?) A ";
	            String query4 = "where rownum <= ? and rownum >= ? order by rownum desc";
	            
	            preparedStatement = connection.prepareStatement(query1 + query2 + query3 + query4);
	            preparedStatement.setString(1, user_id);
				preparedStatement.setInt(2, nEnd);//끝나는 범위를 먼저
				preparedStatement.setInt(3, nStart);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int rownum = resultSet.getInt("rownum");
	                int review_seq = resultSet.getInt("review_seq");
	                String review_content = resultSet.getString("review_content");
	                String user_nick = resultSet.getString("user_nick");
	                Timestamp review_date = resultSet.getTimestamp("review_date");
	                int review_star = resultSet.getInt("review_star");
	                int order_seq = resultSet.getInt("order_seq");
	                
	                DtoReview dto = new DtoReview(rownum, review_seq, review_date, review_content, review_star, user_nick, order_seq);
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
	    	public PageInfo articleMyPageReview(int curPage, String user_id) {

	    		Connection con = null;
	    		PreparedStatement pstmt = null;
	    		ResultSet resultSet = null;

	    		int listCount = 10; // 한 페이지당 보여줄 게시물의 수
	    		int pageCount = 5; // 하단에 보여줄 페이지 리스트의 수

	    		// 총 게시물의 수
	    		int totalCount = 0;
	    		try {
	    			con = dataSource.getConnection();

	    			String query = "select count(*) as total from review where user_id = '" + user_id + "'";
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
