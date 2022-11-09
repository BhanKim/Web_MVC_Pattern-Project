package com.rb.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductManageList;

public class CommandProductOrderAverage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoProductManageList dao = new DaoProductManageList();
		System.out.println("user_order.command");
		
	}

}
