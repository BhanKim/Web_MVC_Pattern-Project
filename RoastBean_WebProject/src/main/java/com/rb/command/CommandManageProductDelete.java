package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;

public class CommandManageProductDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String product_id = request.getParameter("product_id");
		System.out.println("product_id : "+product_id+"입니다.");
		DaoManageProductList dao = new DaoManageProductList();
		dao.manageproductdelete(product_id);

	}

}
