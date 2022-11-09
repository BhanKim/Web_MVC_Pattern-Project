package com.rb.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoBoard {
	
	// F
	public static DaoBoard instance = new DaoBoard();
	DataSource dataSource;
	
	// C
	public DaoBoard() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// M
	public static DaoBoard getInstance() {
		return instance;
	}

} // End
