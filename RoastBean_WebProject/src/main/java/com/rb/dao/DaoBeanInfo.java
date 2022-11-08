package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoBeanInfo;


public class DaoBeanInfo {

	DataSource dataSource;
	
	public DaoBeanInfo() {
		// TODO Auto-generated constructor stub
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    } 

} // End
