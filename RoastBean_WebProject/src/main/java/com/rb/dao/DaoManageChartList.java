package com.rb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.google.gson.Gson;

public class DaoManageChartList {
	
	DataSource dataSource;

	public DaoManageChartList () {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");// 여기까지선언을 다 완료시켜주면 DB가 연결된 것
			// 위에 customer 공간에 스키마 이름을 작성해줘야함
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String chartList () {
		
		Connection connection = null;
		Gson gsonObj = new Gson();
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		
		String dataPoints = null;
	

		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			int xVal, yVal;

			ResultSet resultSet = statement.executeQuery("select visit_date, visit_number from visit");

			while (resultSet.next()) {
				xVal = resultSet.getInt("visit_date");
				yVal = resultSet.getInt("visit_number");
				map = new HashMap<Object, Object>();
				map.put("x", xVal);
				map.put("y", yVal);
				list.add(map);
				dataPoints = gsonObj.toJson(list);
			}
			
			connection.close();
		} catch (SQLException e) {
			System.out.println(
			"<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
			dataPoints = null;
		}
	
		return dataPoints;
		
	}

	public String chartList2 () {
		
		Connection connection = null;
		Gson gsonObj = new Gson();
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list2 = new ArrayList<Map<Object, Object>>();
		
		String dataPoints2 = null;
	

		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			int xVal, yVal;

			ResultSet resultSet = statement.executeQuery("select profit_date, profit_amount from profit");

			while (resultSet.next()) {
				xVal = resultSet.getInt("profit_date");
				yVal = resultSet.getInt("profit_amount");
				map = new HashMap<Object, Object>();
				map.put("x", xVal);
				map.put("y", yVal);
				list2.add(map);
				dataPoints2 = gsonObj.toJson(list2);
			}
			
			connection.close();
		} catch (SQLException e) {
			System.out.println(
			"<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
			dataPoints2 = null;
		}
	
		return dataPoints2;
		
	}
	
}
