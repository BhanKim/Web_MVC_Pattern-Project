package com.rb.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductManageList;
import com.rb.dto.product.DtoProductManageList;

public class CommandProductSearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryname = request.getParameter("query");
		String querycontent = request.getParameter("content");
		
		DaoProductManageList dao = new DaoProductManageList();
		ArrayList<DtoProductManageList> dtos = dao.productsearch(queryname, querycontent);
		request.setAttribute("product_manage", dtos);
	}

}
