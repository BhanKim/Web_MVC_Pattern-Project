package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;
import com.rb.dto.DtoManageProductList;

public class CommandManageProductSeen implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		System.out.println("ManageProductUpdateSelete.command");
		DaoManageProductList dao = new DaoManageProductList();
		DtoManageProductList dto = dao.manageptoductupdateselect(product_id);

				request.setAttribute("product_select", dto);
		System.out.println(product_id + "ManageProductUpdateSelete");
	}

}
