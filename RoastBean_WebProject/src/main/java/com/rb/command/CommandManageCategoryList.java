package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;

public class CommandManageCategoryList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoManageProductList dao = new DaoManageProductList();
		System.out.println("ManageCategoryList.command");
		


	}

}
