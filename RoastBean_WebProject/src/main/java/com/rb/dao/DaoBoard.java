package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoBoard;

public class DaoBoard {
	
	// F
	public static DaoBoard instance = new DaoBoard();
	DataSource dataSource;
	int listCount = 10; // 한페이지당 보여줄 게시물의 수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트의 수
	
	// C
	public DaoBoard() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// M
	public static DaoBoard getInstance() {
		return instance;
	}
	
	// List view
	public ArrayList<DtoBoard> list(int curPage) {
	       
	       //curpage를 받아서 page의 크기를 지정해주는 느낌으로 가야함
	       Connection con = null;
	       PreparedStatement pstmt = null;
	       ResultSet resultSet = null;
	        //전체 게시물의 수
	        int totalCount = 0;
	        try {
	           con = dataSource.getConnection();
	          String query = "select count(*) as total from mvc_board";
	          //총 게시물의 수를 구해주고 이걸 페이지마다 나눠서 보여주는 역할을 함
	          pstmt = con.prepareStatement(query);
	          resultSet = pstmt.executeQuery();
	          if(resultSet.next()) {
	             totalCount = resultSet.getInt("total");
	          }
	        } catch(Exception e) {
	           e.printStackTrace();
	        } finally {
	          try {
	             if(pstmt != null) pstmt.close();//게시물의 수가 null이 아닌경우 쿼리문 닫아줌
	             if(con != null) con.close();
	          } catch(Exception e2) {
	             e2.printStackTrace();
	          }
	       }
	       ArrayList<DtoBoard> dtos = new ArrayList<DtoBoard>();
	       //크기 지정을 해줘서 뽑히려는 게시물의 번호를 지정해준다.
	       
	       int nEnd = (totalCount-(curPage-1)*10);
	       int nStart = (nEnd-9);

	       try {
	          con = dataSource.getConnection();
	          
	          String query = "select * from (select row_number() over(order by bGroup, bIndent desc)"
	                + "as rownum, bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bCnt "
	                + "from mvc_board order by bGroup desc)A where rownum <= ? and rownum >= ?" ;
	          pstmt = con.prepareStatement(query);
	          pstmt.setInt(1, nEnd);//끝나는 범위를 먼저
	          pstmt.setInt(2, nStart);
	          resultSet = pstmt.executeQuery();
	          
	          while(resultSet.next()) {
	             int rownum=resultSet.getInt("rownum");
	             int bId = resultSet.getInt("bId");
	             String bName = resultSet.getString("bName");
	             String bTitle = resultSet.getString("bTitle");
	             String bContent = resultSet.getString("bContent");
	             Timestamp bDate = resultSet.getTimestamp("bDate");
	             int bHit = resultSet.getInt("bHit");
	             int bGroup = resultSet.getInt("bGroup");
	             int bStep = resultSet.getInt("bStep");
	             int bIndent = resultSet.getInt("bIndent");
	             int bCnt = resultSet.getInt("bCnt");
	             
	             DtoBoard dto = new DtoBoard(rownum, bId, bName, bTitle, bContent, null, null, null, bHit, bGroup, bStep, bIndent, bCnt);
	             dtos.add(dto);
	          }
	       } catch(Exception e) {
	          e.printStackTrace();
	       } finally {
	          try {
	             if(resultSet != null) resultSet.close();
	             if(pstmt != null) pstmt.close();
	             if(con != null) con.close();
	          } catch(Exception e2) {
	             e2.printStackTrace();
	          }
	       }
	       return dtos;
	    }

} // End
