package com.rb.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductManageList;

public class CommandProductDelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String product_id = request.getParameter("product_id");
		System.out.println("product_id : "+product_id+"입니다.");
		DaoProductManageList dao = new DaoProductManageList();
		dao.delete(product_id);

	}

}
