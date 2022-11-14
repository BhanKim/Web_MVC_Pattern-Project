package com.rb.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;
import com.rb.dto.DtoManageProductList;

public class CommandManageOrdersSearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryname = request.getParameter("query");
		String querycontent = request.getParameter("content");
		
		System.out.println("ManageOrdersListSearch.command");
		DaoManageProductList dao = new DaoManageProductList();
		ArrayList<DtoManageProductList> dtos = dao.manageorderssearch(queryname, querycontent);
		request.setAttribute("manage_order_list", dtos);
	}

}
