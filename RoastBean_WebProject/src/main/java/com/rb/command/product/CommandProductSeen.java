package com.rb.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductList;
import com.rb.dto.product.DtoProductList;

public class CommandProductSeen implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String product_id = request.getParameter("product_id");
		System.out.println("product_select_update.command");
		DaoProductList dao = new DaoProductList();
		DtoProductList dto = dao.updatelist(product_id);
		
		request.setAttribute("product_select", dto);
		System.out.println(product_id+"commandprductseen");

	}

}
