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
	// 유저의 QnA 전체 리스트 검색 / 22.11.12.SangwonKim
	public ArrayList<DtoQna> qnaList(String user_id){
		ArrayList<DtoQna> dtos = new ArrayList<DtoQna>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select qw.qna_write_category, qw.qna_write_title, qw.qna_write_seq, qw.qna_write_initdate, qw.qna_write_updatedate, qw.qna_write_content, ";
			String query2 = "qwc.qna_write_comment_content, qwc.qna_write_comment_initdate, qwc.qna_write_comment_updatedate from qna_write qw left join qna_write_comment qwc ";
			String query3 = "on qw.qna_write_seq = qwc.qna_write_comment_seq where qw.user_id = '"+user_id+"' order by qw.qna_write_seq desc ";
			preparedStatement = connection.prepareStatement(query1+query2+query3);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String qna_write_category = resultSet.getString("qw.qna_write_category");
				String qna_write_title = resultSet.getString("qw.qna_write_title");
				int qna_write_seq = resultSet.getInt("qw.qna_write_seq");
				String qna_write_initdate = resultSet.getString("qw.qna_write_initdate");
				String qna_write_updatedate = resultSet.getString("qw.qna_write_updatedate");
				String qna_write_content = resultSet.getString("qw.qna_write_content");
				String qna_write_comment_content = resultSet.getString("qwc.qna_write_comment_content");
				String qna_write_comment_initdate = resultSet.getString("qwc.qna_write_comment_initdate");
				String qna_write_comment_updatedate = resultSet.getString("qwc.qna_write_comment_updatedate");
				
				DtoQna dto = new DtoQna(qna_write_seq, qna_write_category, qna_write_title, qna_write_content, qna_write_initdate, qna_write_updatedate, qna_write_comment_content, qna_write_comment_initdate, qna_write_comment_updatedate);
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
	} // 유저의 QnA 전체 리스트 검색
	
	// 관리자의 QnA 전체 리스트 검색 / 22.11.13.SangwonKim
	public ArrayList<DtoQna> qnaListAdmin(){
		ArrayList<DtoQna> dtos = new ArrayList<DtoQna>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select qw.user_id, qw.qna_write_category, qw.qna_write_title, qw.qna_write_seq, qw.qna_write_initdate, qw.qna_write_updatedate, qw.qna_write_content, ";
			String query2 = "qwc.qna_write_comment_seq, qwc.qna_write_comment_content, qwc.qna_write_comment_initdate, qwc.qna_write_comment_updatedate ";
			String query3 = "from qna_write qw left join qna_write_comment qwc on qw.qna_write_seq = qwc.qna_write_seq "
						  + "order by qw.qna_write_seq desc, qwc.qna_write_comment_seq asc ";
			preparedStatement = connection.prepareStatement(query1+query2+query3);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String user_id = resultSet.getString("qw.user_id");
				String qna_write_category = resultSet.getString("qw.qna_write_category");
				String qna_write_title = resultSet.getString("qw.qna_write_title");
				int qna_write_seq = resultSet.getInt("qw.qna_write_seq");
				String qna_write_initdate = resultSet.getString("qw.qna_write_initdate");
				String qna_write_updatedate = resultSet.getString("qw.qna_write_updatedate");
				String qna_write_content = resultSet.getString("qw.qna_write_content");
				int qna_write_comment_seq = resultSet.getInt("qwc.qna_write_comment_seq");
				String qna_write_comment_content = resultSet.getString("qwc.qna_write_comment_content");
				String qna_write_comment_initdate = resultSet.getString("qwc.qna_write_comment_initdate");
				String qna_write_comment_updatedate = resultSet.getString("qwc.qna_write_comment_updatedate");
				
				DtoQna dto = new DtoQna(user_id, qna_write_category, qna_write_title, qna_write_seq, qna_write_content, qna_write_initdate, qna_write_updatedate, qna_write_comment_seq, qna_write_comment_content, qna_write_comment_initdate, qna_write_comment_updatedate);
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
	} // 관리자의 QnA 전체 리스트 검색
	
	
	// Mypage User의 QnA Question Insert / 22.11.13.SangwonKim
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
	} // Mypage User의 QnA Question Insert
	
	// Customer Service User의 QnA Answer Update / 22.11.13.SangwonKim
	public void userQuestionUpdate(String qna_write_seq, String qna_write_title, String qna_write_content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update qna_write set qna_write_title = ?, qna_write_content = ?, qna_write_updatedate = now() where qna_write_seq = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, qna_write_title);
			preparedStatement.setString(2, qna_write_content);
			preparedStatement.setString(3, qna_write_seq);
			
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
	} // Customer Service User의 QnA Answer Update

	// Customer Service Admin의 QnA Answer Insert / 22.11.13.SangwonKim
	public void adminAnswerInsert(String admin_id, String qna_write_seq, String qna_write_comment_content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into qna_write_comment (admin_id, qna_write_seq, qna_write_comment_content, qna_write_comment_initdate) values (?,?,?,now()) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin_id);
			preparedStatement.setString(2, qna_write_seq);
			preparedStatement.setString(3, qna_write_comment_content);
			
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
	} // Customer Service Admin의 QnA Answer Insert
	
	// Customer Service Admin의 QnA Answer Update / 22.11.13.SangwonKim
	public void adminAnswerUpdate(String qna_write_seq, String qna_write_comment_content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update qna_write_comment set qna_write_comment_content = ?, qna_write_comment_updatedate = now() where qna_write_seq = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, qna_write_comment_content);
			preparedStatement.setString(2, qna_write_seq);
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
	} // Customer Service Admin의 QnA Answer Update
	

	// 22-11-19 호식 - 당일 들어온 Qna 문의수량 구하기
	public int qna_date_sum() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(qna_write_initdate) as qna_date_sum from qna_write where DATE_FORMAT(qna_write_initdate, '%Y-%m-%d') = curdate();";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("qna_date_sum");
				
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
	}//---qna_date_sum END
	
	// 22-11-19 호식 - 당일 들어온 Qna 문의수량 구하기
		public int qna_total_sum() {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			int result = 0;
			try {
				connection = dataSource.getConnection();
				String query = "select count(*) as totalcount from qna_write;";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					result = resultSet.getInt("totalcount");
					
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
		}//---qna_date_sum END
	
	public int qna_anwer_sum() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int result = 0;
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) as count from qna_write_comment";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("count");
				
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
	}//---qna_date_sum END
	
	
	
}//class end 
