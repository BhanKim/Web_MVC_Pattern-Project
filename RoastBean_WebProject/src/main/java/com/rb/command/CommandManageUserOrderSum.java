package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rb.dao.DaoManageProductList;

public class CommandManageUserOrderSum implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		System.out.println("ManageUserOrderSum.command");
		 DaoManageProductList dao = new DaoManageProductList();
		 
		 int order_date_sum = dao.manageuserorderselect();

		 session.setAttribute("order_date_sum", order_date_sum);
	}

}
