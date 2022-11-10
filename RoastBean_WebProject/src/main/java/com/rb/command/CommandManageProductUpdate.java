package com.rb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.DaoManageProductList;

public class CommandManageProductUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		String product_nation = request.getParameter("product_nation");
		String product_image = request.getParameter("product_image");
		String product_info = request.getParameter("product_info");
		int product_stock = Integer.parseInt(request.getParameter("product_stock"));
		int product_weight = Integer.parseInt(request.getParameter("product_weight"));
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		int sproduct_id = Integer.parseInt(request.getParameter("product_id"));

		DaoManageProductList dao = new DaoManageProductList();
		System.out.println(sproduct_id + "commandproductupdate");
		dao.manageptoductupdate(product_name, product_nation, product_image, product_info, product_stock,
				product_weight, product_price, sproduct_id);

	}

}
