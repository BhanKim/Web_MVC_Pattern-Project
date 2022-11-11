package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoComment;


public class DaoComment {

	
	// F
	private static DaoComment instance = new DaoComment();
	DataSource dataSource;
	
	// C
	public DaoComment() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static DaoComment getInstance() {
		return instance;
	}
	
	// M
	// List Comment
    public ArrayList<DtoComment> commentList(String strID) {
    	
    	ArrayList<DtoComment> dtos = new ArrayList<DtoComment>();
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	
    	try {
    		con = dataSource.getConnection();
    		
    		String query = "select * from community_comment where community_id = ? order by community_comment_cono";
    		pstmt = con.prepareStatement(query);
    		pstmt.setInt(1, Integer.parseInt(strID));
    		resultSet = pstmt.executeQuery();
    		
    		while(resultSet.next()) {
    			
    			int community_id = resultSet.getInt("community_id");
    			int community_comment_cono = resultSet.getInt("community_comment_cono");
    			String community_comment_name = resultSet.getString("community_comment_name");
    			String community_comment_content = resultSet.getString("community_comment_content");
    			String community_comment_codate = resultSet.getString("community_comment_codate");
    			
    			DtoComment dto =new DtoComment(community_id, community_comment_cono, community_comment_name, community_comment_content, community_comment_codate);
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
    
    // 댓글 작성
    public void coWrite(String community_id, String community_comment_name, String community_comment_content) {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	
    	try {
    		System.out.println("<<< enter comment dao write");
    		System.out.println(community_id);
    		System.out.println(community_comment_name);
    		System.out.println(community_comment_content);
    		con = dataSource.getConnection();
    		String query = "insert into community_comment " +
    					   " (community_id, community_comment_name, community_comment_content, community_comment_codate)" +
    					   " values (?, ?, ?, now())";
    		pstmt = con.prepareStatement(query);
    		pstmt.setInt(1, Integer.parseInt(community_id));
    		pstmt.setString(2, community_comment_name);
    		pstmt.setString(3, community_comment_content);
    		pstmt.executeUpdate();
    		
    		System.out.println(community_id);
    		System.out.println(community_comment_name);
    		System.out.println(community_comment_content);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("error");
    	} finally {
    		try {
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    	
    }
    
	// 답글기능 ----------------------------
	public void reply(String community_id, String community_name, String community_title, String community_content, 
			String community_group, String community_step, String community_indent) {
//		replyShape(bGroup, bStep);
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "insert into community " + " (community_name, community_title, community_content, community_group, "
					+ "community_step, community_indent, community_cnt) "
					+ " values (?, ?, ?, ?, ?, ?, 0)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, community_name);
			pstmt.setString(2, community_title);
			pstmt.setString(3, community_content);
			pstmt.setInt(4, Integer.parseInt(community_group));
			pstmt.setInt(5, Integer.parseInt(community_step) + 1);
			pstmt.setInt(6, Integer.parseInt(community_indent) + 1);
			pstmt.executeUpdate();

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
	}
		
	
	
	
	
	
	
	
	
	
	
	
} // End
