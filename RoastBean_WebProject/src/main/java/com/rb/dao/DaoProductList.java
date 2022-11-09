package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoProductList;

public class DaoProductList {
	
	DataSource dataSource;

    public DaoProductList() {
        // TODO Auto-generated constructor stub
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    // 전체 검색
    public ArrayList<DtoProductList> list() {
        ArrayList<DtoProductList> dtos = new ArrayList<DtoProductList>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            
            connection = dataSource.getConnection();

            String query = "select product_id, product_name, product_weight, product_info, product_price, product_stock from product";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String product_name = resultSet.getString("product_name");
                int product_weight = resultSet.getInt("product_weight");
                String product_info = resultSet.getString("product_info");
                int product_price = resultSet.getInt("product_price");
                int product_stock = resultSet.getInt("product_stock");

                DtoProductList dto = new DtoProductList(product_id, product_name, product_weight, product_info, product_price, product_stock);
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

}