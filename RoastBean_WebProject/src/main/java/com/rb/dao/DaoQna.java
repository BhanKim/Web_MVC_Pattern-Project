package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoQna;

public class DaoQna {
	
	// Fields
	DataSource dataSource;
	
	// Constructor
	public DaoQna() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Method
	// 나의 QnA 전체 리스트 검색
	public ArrayList<DtoQna> qnaList(String user_id){
		ArrayList<DtoQna> dtos = new ArrayList<DtoQna>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select qw.qna_write_category, qw.qna_write_title, qw.qna_write_seq, qw.qna_write_initdate, qw.qna_write_content, ";
			String query2 = "qwc.qna_write_comment_content, qwc.qna_write_comment_initdate from qna_write qw, qna_write_comment qwc ";
			String query3 = "where qw.qna_write_seq = qwc.qna_write_comment_seq and qw.user_id = '"+user_id+"' order by qw.qna_write_initdate asc ";
			preparedStatement = connection.prepareStatement(query1+query2+query3);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String qna_write_category = resultSet.getString("qw.qna_write_category");
				String qna_write_title = resultSet.getString("qw.qna_write_title");
				int qna_write_seq = resultSet.getInt("qw.qna_write_seq");
				String qna_write_initdate = resultSet.getString("qw.qna_write_initdate");
				String qna_write_content = resultSet.getString("qw.qna_write_content");
				String qna_write_comment_content = resultSet.getString("qwc.qna_write_comment_content");
				String qna_write_comment_initdate = resultSet.getString("qwc.qna_write_comment_initdate");
				
				DtoQna dto = new DtoQna(qna_write_seq, qna_write_category, qna_write_title, qna_write_content, qna_write_initdate, qna_write_comment_content, qna_write_comment_initdate);
				dtos.add(dto);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	} // list
	
	// customer service > QnA Insert
	public void userQuestionInsert(String user_id, String qna_write_category, String qna_write_title, String qna_write_content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into qna_write (user_id, qna_write_category, qna_write_title, qna_write_content, qna_write_initdate) values (?,?,?,?,now()) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, qna_write_category);
			preparedStatement.setString(3, qna_write_title);
			preparedStatement.setString(4, qna_write_content);
			
			preparedStatement.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // customer service > QnA Insert

}
