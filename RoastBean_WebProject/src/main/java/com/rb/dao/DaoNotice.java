package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoNotice;


public class DaoNotice {
	
	// Fields
	DataSource dataSource;
	
	// Constructor
	public DaoNotice() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Method
	// 전체 검색
	public ArrayList<DtoNotice> list(){
		ArrayList<DtoNotice> dtos = new ArrayList<DtoNotice>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select notice_write_seq, notice_write_title, notice_write_content, notice_write_initdate, notice_write_updatedate from notice_write ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int notice_write_seq = resultSet.getInt("notice_write_seq");
				String notice_write_title = resultSet.getString("notice_write_title");
				String notice_write_content = resultSet.getString("notice_write_content");
				String notice_write_initdate = resultSet.getString("notice_write_initdate");
				String notice_write_updatedate = resultSet.getString("notice_write_updatedate");
				
				DtoNotice dto = new DtoNotice(notice_write_seq, notice_write_title, notice_write_content, notice_write_initdate, notice_write_updatedate);
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

}