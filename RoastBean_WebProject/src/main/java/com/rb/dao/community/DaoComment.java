package com.rb.dao.community;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoComment {

	
	// F
	private static DaoComment instance = new DaoComment();
	DataSource dataSource;
	
	// C
	public DaoComment() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/testmvc");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static DaoComment getInstance() {
		return instance;
	}
	
	
	// M
	
	
	
	
	
	
	
	
	
	
	
} // End
