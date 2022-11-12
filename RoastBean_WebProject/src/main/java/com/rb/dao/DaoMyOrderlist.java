package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoMyOrderlist;

public class DaoMyOrderlist {

	DataSource dataSource;

    public DaoMyOrderlist() {
        // TODO Auto-generated constructor stub
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 전체 검색
    public ArrayList<DtoMyOrderlist> myOrderList(String user_id) {
    	ArrayList<DtoMyOrderlist> dtos = new ArrayList<DtoMyOrderlist>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();

            String query1 = "select p.product_id, p.product_image, p.product_name, p.product_weight, o.order_seq, o.order_date, o.order_price, o.order_qty "; 
    		String query2 = "from user u, product p, orders o  where u.user_id = '" + user_id + "' ";
    		String query3 = "and u.user_id = o.user_id and p.product_id = o.product_id group by o.order_seq, p.product_id, o.order_date, o.order_price, o.order_qty";
            		
            preparedStatement = connection.prepareStatement(query1+query2+query3);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	int product_id = resultSet.getInt(1);
            	String product_image = resultSet.getString(2);
                String product_name = resultSet.getString(3);
                int product_weight = resultSet.getInt(4);
                int order_seq = resultSet.getInt(5);
                String order_date = resultSet.getString(6);
                int order_price = resultSet.getInt(7);
                int order_qty = resultSet.getInt(8);

                DtoMyOrderlist dto = new DtoMyOrderlist(product_id, order_seq, product_image, product_name, product_weight, order_date, order_price, order_qty);
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
