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
	          String query = "select count(*) as total from community";
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
	          
	          String query = "select * from (select row_number() over(order by community_group, community_indent desc)"
	                + "as rownum, community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt "
	                + "from community order by community_group desc)A where rownum <= ? and rownum >= ?" ;
	          pstmt = con.prepareStatement(query);
	          pstmt.setInt(1, nEnd);//끝나는 범위를 먼저
	          pstmt.setInt(2, nStart);
	          resultSet = pstmt.executeQuery();
	          
	          while(resultSet.next()) {
	             int rownum=resultSet.getInt("rownum");
	             int community_id = resultSet.getInt("community_id");
	             String community_name = resultSet.getString("community_name");
	             String community_title = resultSet.getString("community_title");
	             String community_content = resultSet.getString("community_content");
	             String community_initdate = resultSet.getString("community_initdate");
	             String community_updatedate = resultSet.getString("community_updatedate");
	             String community_deletedate = resultSet.getString("community_deletedate");
	             int community_hit = resultSet.getInt("community_hit");
	             int community_group = resultSet.getInt("community_group");
	             int community_step = resultSet.getInt("community_step");
	             int community_indent = resultSet.getInt("community_indent");
	             int community_cnt = resultSet.getInt("community_cnt");
	             
	             DtoBoard dto = new DtoBoard(rownum, community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt);
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
	
    // 공지사항
    public ArrayList<DtoBoard> noticeList() {
    	
    	ArrayList<DtoBoard> dtos = new ArrayList<DtoBoard>();
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	
    	try {
    		con = dataSource.getConnection();
    		
    		String query = "select * from community where community_name = 'admin' " +
    					   " order by community_initdate desc ";
    		pstmt = con.prepareStatement(query);
    		resultSet = pstmt.executeQuery();
    		
    		while(resultSet.next()) {
    			
    			int community_id = resultSet.getInt("community_id");
    			String community_name = resultSet.getString("community_name");
    			String community_title = resultSet.getString("community_title");
    			String community_content = resultSet.getString("community_content");
    			String community_initdate = resultSet.getString("community_initdate");
    			String community_updatedate = resultSet.getString("community_updatedate");
    			String community_deletedate = resultSet.getString("community_deletedate");
    			int community_hit = resultSet.getInt("community_hit");
    			int community_group = resultSet.getInt("community_group");
    			int community_step = resultSet.getInt("community_step");
    			int community_indent = resultSet.getInt("community_indent");
    			int community_cnt = resultSet.getInt("community_cnt");
    			
    			DtoBoard dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt);
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
	
	   // total 게시글 페이징
    public PageInfo articlePage(int curPage) {
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	
    	int listCount = 10;		// 한 페이지당 보여줄 게시물의 수
        int pageCount = 5;		// 하단에 보여줄 페이지 리스트의 수
        
        // 총 게시물의 수
        int totalCount = 0;
        try {
        	con = dataSource.getConnection();
        	
    		String query = "select count(*) as total from community";
    		pstmt = con.prepareStatement(query);
    		resultSet = pstmt.executeQuery();
    		
    		if(resultSet.next()) {
    			totalCount = resultSet.getInt("total");
    		}
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
    		try {
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
        
        // 총 페이지 수 
        int totalPage = totalCount / listCount;
        if(totalCount % listCount > 0)
        	totalPage++;
        
        // 현재 페이지
        int myCurPage = curPage;
        if(myCurPage > totalPage)
        	myCurPage = totalPage;
        if(myCurPage < 1)
        	myCurPage = 1;
        
        // 시작 페이지
        int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
        
        // 끝 페이지
        int endPage = startPage + pageCount - 1;
        if(endPage > totalPage)
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

} // End
