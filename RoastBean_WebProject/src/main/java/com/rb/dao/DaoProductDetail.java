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

public class DaoProductDetail {
	
	DataSource dataSource;

    public DaoProductDetail() {
        // TODO Auto-generated constructor stub
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 전체 검색
    public DtoProductList list(int pproduct_id) {
        DtoProductList dtos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            
            connection = dataSource.getConnection();

            String query = "select product_id, product_name, product_weight, product_info, product_price, product_stock, product_image from product where product_id = " + pproduct_id;
            
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int product_weight = resultSet.getInt("product_weight");
                String product_info = resultSet.getString("product_info");
                int product_price = resultSet.getInt("product_price");
                int product_stock = resultSet.getInt("product_stock");
                String product_image = resultSet.getString("product_image");

                dtos = new DtoProductList(product_id, product_name, product_weight, product_info, product_price, product_stock, product_image);
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
    
    public ArrayList<DtoReview> reviewList(int pproduct_id, int curPage) {
    	ArrayList<DtoReview> dtos = new ArrayList<DtoReview>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int totalCount = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) as total from review where product_id = " + pproduct_id;
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
            String query2 = "as rownum, r.review_seq, r.review_content, u.user_nick, r.review_date, r.review_star ";
            String query3 = "from review as r, user as u where r.user_id = u.user_id and r.product_id = ?) A ";
            String query4 = "where rownum <= ? and rownum >= ? order by rownum desc";
            
            preparedStatement = connection.prepareStatement(query1 + query2 + query3 + query4);
            preparedStatement.setInt(1, pproduct_id);
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
                
                DtoReview dto = new DtoReview(rownum, review_seq, review_date, review_content, review_star, user_nick);
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
    	public PageInfo articlePageReview(int curPage, int pproduct_id) {

    		Connection con = null;
    		PreparedStatement pstmt = null;
    		ResultSet resultSet = null;

    		int listCount = 10; // 한 페이지당 보여줄 게시물의 수
    		int pageCount = 5; // 하단에 보여줄 페이지 리스트의 수

    		// 총 게시물의 수
    		int totalCount = 0;
    		try {
    			con = dataSource.getConnection();

    			String query = "select count(*) as total from review where product_id = " + pproduct_id;
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
    	
    	public DtoProductList avgCountStar(int pproduct_id) {
            DtoProductList dtos = null;
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                
                connection = dataSource.getConnection();

                String query = "select (sum(review_star) / count(review_star)) as avgStar, count(review_star) as sumReview from review where product_id = " + pproduct_id;
                
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                	double avgStar = resultSet.getInt("avgStar");
                    int sumReview = resultSet.getInt("sumReview");

                    dtos = new DtoProductList(avgStar, sumReview);
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


