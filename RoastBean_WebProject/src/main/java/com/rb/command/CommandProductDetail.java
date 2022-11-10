package com.rb.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoProductDetail;
import com.rb.dto.DtoProductList;

public class CommandProductDetail implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		DaoProductDetail dao = new DaoProductDetail();
        DtoProductList dtos = dao.list(product_id);
        request.setAttribute("productDetail", dtos);
	}

}