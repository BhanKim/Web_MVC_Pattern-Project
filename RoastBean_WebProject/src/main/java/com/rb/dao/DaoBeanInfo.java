package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoBeanInfo;
import com.rb.dto.DtoBoard;

public class DaoBeanInfo {

	public static DaoBeanInfo instance = new DaoBeanInfo();
	DataSource dataSource;
	int listCount = 6; // 한페이지당 보여줄 게시물의 수
	int pageCount = 3; // 하단에 보여줄 페이지 리스트의 수

	public DaoBeanInfo() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbeanswkim");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// M
	public static DaoBeanInfo getInstance() {
		return instance;
	}

	// 전체 검색
	public ArrayList<DtoBeanInfo> list() {
		ArrayList<DtoBeanInfo> dtos = new ArrayList<DtoBeanInfo>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = dataSource.getConnection();

			String query = "select beaninfo_id, beaninfo_name, beaninfo_content, beaninfo_url from beaninfo";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int beaninfo_id = resultSet.getInt("beaninfo_id");
				String beaninfo_name = resultSet.getString("beaninfo_name");
				String beaninfo_content = resultSet.getString("beaninfo_content");
				String beaninfo_url = resultSet.getString("beaninfo_url");

				DtoBeanInfo dto = new DtoBeanInfo(beaninfo_id, beaninfo_name, beaninfo_content, beaninfo_url);
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
	} // list 끝

	public BeanInfo articlePage(int curPage) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		int listCount = 6; // 한 페이지당 보여줄 게시물의 수
		int pageCount = 3; // 하단에 보여줄 페이지 리스트의 수

		// 총 게시물의 수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();

			String query = "select count(*) as total from beaninfo";
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

		BeanInfo binfo = new BeanInfo();
		binfo.setTotalCount(totalCount);
		binfo.setListCount(listCount);
		binfo.setTotalPage(totalPage);
		binfo.setCurPage(curPage);
		binfo.setPageCount(pageCount);
		binfo.setStartPage(startPage);
		binfo.setEndPage(endPage);

		return binfo;
	} // articlePage end

	public ArrayList<DtoBeanInfo> list(int curPage) {

		// curpage를 받아서 page의 크기를 지정해주는 느낌으로 가야함
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		// 전체 게시물의 수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();
			String query = "select count(*) as total from beaninfo";
			// 총 게시물의 수를 구해주고 이걸 페이지마다 나눠서 보여주는 역할을 함
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
					pstmt.close();// 게시물의 수가 null이 아닌경우 쿼리문 닫아줌
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		ArrayList<DtoBeanInfo> dtos = new ArrayList<DtoBeanInfo>();
		// 크기 지정을 해줘서 뽑히려는 게시물의 번호를 지정해준다.

		int nEnd = (totalCount - (curPage - 1) * 6);
		int nStart = (nEnd - 5);

		try {
			con = dataSource.getConnection();
			
			String query = "select * from (select row_number() over(order by beaninfo_id desc)"
					+ "as rownum, beaninfo_id, beaninfo_name, beaninfo_content, beaninfo_url "
					+ "from beaninfo order by beaninfo_id desc)A where rownum <= ? and rownum >= ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nEnd);// 끝나는 범위를 먼저
			pstmt.setInt(2, nStart);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				int rownum = resultSet.getInt("rownum");
				int beaninfo_id = resultSet.getInt("beaninfo_id");
				String beaninfo_name = resultSet.getString("beaninfo_name");
				String beaninfo_content = resultSet.getString("beaninfo_content");
				String beaninfo_url = resultSet.getString("beaninfo_url");

				DtoBeanInfo dto = new DtoBeanInfo(rownum, beaninfo_id, beaninfo_name, beaninfo_content, beaninfo_url);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	} // list end

} // End
