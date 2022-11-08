package com.rb.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductList;
import com.rb.dto.product.DtoProductList;

public class CommandProductSearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryname = request.getParameter("query");
		String querycontent = request.getParameter("content");
		
		DaoProductList dao = new DaoProductList();
		ArrayList<DtoProductList> dtos = dao.productsearch(queryname, querycontent);
		request.setAttribute("product_manage", dtos);
	}

}
