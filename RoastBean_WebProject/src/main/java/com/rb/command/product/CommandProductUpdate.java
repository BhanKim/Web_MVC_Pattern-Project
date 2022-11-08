package com.rb.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rb.dao.product.DaoProductList;

public class CommandProductUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		String product_nation = request.getParameter("product_nation");
		String product_image = request.getParameter("product_image");
		String product_info = request.getParameter("product_info");
		String product_stock = request.getParameter("product_stock");
		String product_weight = request.getParameter("product_weight");
		String product_price = request.getParameter("product_price");
		String sproduct_id = request.getParameter("product_id");

		DaoProductList dao = new DaoProductList();
		System.out.println(sproduct_id+"commandproductupdate");
		dao.update(product_name,product_nation,product_image, product_info, product_stock, product_weight, product_price,sproduct_id);
		

	}

}
